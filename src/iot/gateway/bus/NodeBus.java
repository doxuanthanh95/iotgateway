package iot.gateway.bus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.jdbc.ConnectionImpl;
import com.sun.corba.se.impl.orbutil.graph.Node;

import iot.gateway.dto.NodeDto;
import iot.gateway.log.NodeImplLog;
import iot.gateway.log.NodeLog;
import iot.gateway.util.ConnPoolImplUtil;
import iot.gateway.util.ConnPoolUtil;

/**
 * Servlet implementation class NodeBus
 */
@WebServlet(name="NodeBus", urlPatterns="/node")
public class NodeBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NodeBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String nodeId = request.getParameter("nodeId");
		Integer intNodeId = (nodeId != null && !nodeId.isEmpty() && isNumber(nodeId)) ? Integer.parseInt(nodeId) : null;
		PrintWriter pw = response.getWriter();
		if(intNodeId != null){
			ConnPoolUtil cp = ConnPoolImplUtil.getInstance();
			NodeImplLog nodeLog = new NodeImplLog(cp);
			NodeDto nodeDto = nodeLog.getNodeById(Integer.parseInt(nodeId));
			nodeLog.releaseConnection();
			nodeLog.refreshConnection();
			String jsonNodeDto = new Gson().toJson(nodeDto);
			System.out.println(jsonNodeDto);
			pw.write(jsonNodeDto);
		}else{
			pw.write("error");
		}
		pw.flush();
	}

	public boolean isNumber(String isNum){
		 try
		   {
		      Integer.parseInt( isNum );
		      return true;
		   }
		   catch( Exception ex )
		   {
		      return false;
		   }
	}
}
