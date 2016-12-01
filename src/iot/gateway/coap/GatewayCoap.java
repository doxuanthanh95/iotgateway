package iot.gateway.coap;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapClient;

import com.google.gson.Gson;

import iot.gateway.dto.NodeDto;
import iot.gateway.log.NodeImplLog;
import iot.gateway.util.ConnPoolImplUtil;

public class GatewayCoap {
	public static void getInfoFromServer() {
		// final CoapClient client1 = new
		// CoapClient("coap://192.168.48.128:5683/code");
		// final CoapClient client2 = new
		// CoapClient("coap://192.168.48.128:5683/code");
		// final CoapClient client3 = new
		// CoapClient("coap://192.168.48.128:5683/code");
		ConnPoolImplUtil cp = ConnPoolImplUtil.getInstance();
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				NodeImplLog nodeLog = new NodeImplLog(cp);
				NodeDto nodeDto1, nodeDto2, nodeDto3;
				try {

					// nodeDto1 = new
					// Gson().fromJson(client1.get().getResponseText(),
					// NodeDto.class);
					nodeDto1 = runAnalysis("coap://[fec0::4]/r");
					if (nodeDto1 != null) {
						nodeDto1.setNodeId(1);
						nodeLog.updateNode(nodeDto1);
						nodeDto1.show();
					} else {
						nodeDto1 = new NodeDto(1, 0.0f, 0.0f, 0.0f, 1, 0);
						nodeLog.updateNode(nodeDto1);
						System.out.println("Node 1 died");
					}
				} catch (Exception ex) {
					nodeDto1 = new NodeDto(1, 0.0f, 0.0f, 0.0f, 1, 0);
					nodeLog.updateNode(nodeDto1);
					System.out.println("Node 1 died");
				}

				try {

					// nodeDto2 = new
					// Gson().fromJson(client2.get().getResponseText(),
					// NodeDto.class);
					nodeDto2 = runAnalysis("coap://[fec0::2]/r");
					if (nodeDto2 != null) {
						nodeDto2.setNodeId(2);
						nodeLog.updateNode(nodeDto2);
						nodeDto2.show();
					} else {
						nodeDto2 = new NodeDto(2, 0.0f, 0.0f, 0.0f, 1, 0);
						nodeLog.updateNode(nodeDto2);
						System.out.println("Node 2 died");
					}
				} catch (Exception ex) {
					nodeDto2 = new NodeDto(2, 0.0f, 0.0f, 0.0f, 1, 0);
					nodeLog.updateNode(nodeDto2);
					System.out.println("Node 2 died");
				}

				try {
					// nodeDto3 = new
					// Gson().fromJson(client3.get().getResponseText(),
					// NodeDto.class);
					nodeDto3 = runAnalysis("coap://[fec0::3]/r");
					if (nodeDto3 != null) {
						nodeDto3.setNodeId(3);
						nodeLog.updateNode(nodeDto3);
						nodeDto3.show();
					} else {
						nodeDto3 = new NodeDto(3, 0.0f, 0.0f, 0.0f, 1, 0);
						nodeLog.updateNode(nodeDto3);
						System.out.println("Node 3 died");
					}
				} catch (Exception ex) {
					nodeDto3 = new NodeDto(3, 0.0f, 0.0f, 0.0f, 1, 0);
					nodeLog.updateNode(nodeDto3);
					System.out.println("Node 3 died");
				}
				nodeLog.releaseConnection();
			}
		}, 5000, 5000);

	}

	public static NodeDto runAnalysis(String ipV6Par) {
		// System.out.println("Test" + dirUpload);
		//System.out.println("hsahahahaha" + ipV6Par);
		Process p = null;

		NodeDto nodeDto = new NodeDto();
		try {
			ProcessBuilder pb = new ProcessBuilder("./coap-client", "-m", "get", ipV6Par);
			pb.directory(new File("/opt/tinyos-2.1.2/support/sdk/c/coap/examples"));
			p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";

			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("retransmission")) {
					p.destroy();
					return null;
				}
				if (line.contains("Temperature")) {

					nodeDto.setTemp(Float.parseFloat(getValueFromLine(line))-274.15f);
				}
				if (line.contains("Humidity")) {
					nodeDto.setHumi(Float.parseFloat(getValueFromLine(line)));
				}
				if (line.contains("Voltage")) {
					nodeDto.setLight(Float.parseFloat(getValueFromLine(line)));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			p.destroy();
		}
		// return lineCmd;
		return nodeDto;
	}

	public static String getValueFromLine(String par) {
		String[] spiltPar = par.split(":");
		return spiltPar[1].trim().split(" ")[0];
	}
}
