package iot.gateway.bus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

import com.google.gson.Gson;

import iot.gateway.dto.MapDto;
import iot.gateway.dto.NodeDto;
import iot.gateway.log.MapImplLog;
import iot.gateway.log.MapLog;
import iot.gateway.log.NodeImplLog;
import iot.gateway.log.NodeLog;
import iot.gateway.util.ConnPoolImplUtil;
import iot.gateway.util.ConnPoolUtil;

/**
 * Servlet implementation class StatisticsBus
 */
@WebServlet(name="StatisticsBus", urlPatterns="/statistics")
public class StatisticsBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("serial")
		HashMap<String, String> page = new HashMap<String, String>(){{
			put("title", "Statistic"); put("layout", "layout/statistics.jsp");}
		};
		
		ConnPoolUtil cp = ConnPoolImplUtil.getInstance();
		MapImplLog mapLog = new MapImplLog(cp);
		List<MapDto> listMap = mapLog.getAllMap();
		
		mapLog.releaseConnection();
		request.setAttribute("page", page);
		request.setAttribute("listMap", listMap);
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String mapId = request.getParameter("mapId");
		ConnPoolImplUtil cp = ConnPoolImplUtil.getInstance();
		NodeImplLog nodeLog = new NodeImplLog(cp);
		List<NodeDto> listNode = nodeLog.getNodeByMapId(Integer.parseInt(mapId));
		String jsonListNode = new Gson().toJson(listNode);
		nodeLog.releaseConnection();
		System.out.println(jsonListNode);
		PrintWriter pw = response.getWriter();
		pw.write(jsonListNode);
		pw.flush();
	}


}
