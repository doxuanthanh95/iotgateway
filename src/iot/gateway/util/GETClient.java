package iot.gateway.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;

import com.google.gson.Gson;

import iot.gateway.dto.NodeDto;

public class GETClient {
	/*
	 * Application entry point.
	 * 
	 */
	public static NodeDto runApkAnalysis() {
		// System.out.println("Test" + dirUpload);
		String lineCmd = null;
		Process p = null;
		NodeDto nodeDto = new NodeDto();
		try {
			ProcessBuilder pb = new ProcessBuilder("./coap-client", "-m", "get", "coap://[fec0::2]/r");
			pb.directory(new File("/opt/tinyos-2.1.2/support/sdk/c/coap/examples"));
			p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("Temperature")) {
					nodeDto.setTemp(Float.parseFloat(getValueFromLine(line)));
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

	public static void main(String args[]) {
		runApkAnalysis();

		// final CoapClient client = new CoapClient("coap://[fec0::2]:61616/r");
		// System.out.println(client.get().getResponseText());

		/*
		 * GETClient obj = new GETClient();
		 * 
		 * String domainName = "google.com";
		 * 
		 * //in mac oxs String command = "ping google.com";
		 * 
		 * //in windows //String command = "ping -n 3 " + domainName;
		 * 
		 * String output = obj.executeCommand(command);
		 * 
		 * System.out.println(output);
		 * 
		 * }
		 * 
		 * private String executeCommand(String command) {
		 * 
		 * StringBuffer output = new StringBuffer();
		 * 
		 * Process p; try { p = Runtime.getRuntime().exec(command); p.waitFor();
		 * BufferedReader reader = new BufferedReader(new
		 * InputStreamReader(p.getInputStream()));
		 * 
		 * String line = ""; while ((line = reader.readLine())!= null) {
		 * output.append(line + "\n"); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return output.toString();
		 */

		// System.out.println("SYNCHRONOUS");
		/*
		 * Timer timer = new Timer(); timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * 
		 * NodeDto s = new Gson().fromJson(client.get().getResponseText(),
		 * NodeDto.class); s.show(); } }, 2000, 2000);
		 */
	}
}
