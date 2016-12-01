package iot.gateway.bus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ConnectionImpl;

import iot.gateway.dto.MapDto;
import iot.gateway.dto.NodeDto;
import iot.gateway.log.MapImplLog;
import iot.gateway.log.MapLog;
import iot.gateway.log.NodeImplLog;
import iot.gateway.util.ConnPoolImplUtil;
import iot.gateway.util.ConnPoolUtil;

/**
 * Servlet implementation class MapViewBus
 */
@WebServlet(name="MapViewBus", urlPatterns="/map-view")
public class MapViewBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public MapViewBus() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mapId = request.getParameter("mapid");
		String layout = new String();
		@SuppressWarnings("serial")
		HashMap<String, String> page = new HashMap<String, String>(){{
			put("title", "Map View");}
		};
		ConnPoolUtil cp = ConnPoolImplUtil.getInstance();
		MapImplLog mapLog = new MapImplLog(cp);
		NodeImplLog nodeLog = new NodeImplLog(cp);
		
		List<MapDto> listMap = new ArrayList<MapDto>();
		
		Integer intMapId = (mapId != null && !mapId.isEmpty() && isNumber(mapId)) ? Integer.parseInt(mapId) : null;
		if(intMapId != null){
			List<NodeDto> listNode = nodeLog.getNodeByMapId(intMapId);
			MapDto mapDto = mapLog.getMapById(intMapId);
			request.setAttribute("map", mapDto);
			request.setAttribute("listNode", listNode);
			layout = "layout/mapdetail.jsp";
		}else{
			listMap = mapLog.getAllMap();
			request.setAttribute("listMap", listMap);
			layout = "layout/mapview.jsp";
		}
		page.put("layout", layout);
		
		nodeLog.releaseConnection();
		nodeLog.refreshConnection();
		mapLog.releaseConnection();
		mapLog.refreshConnection();
		

		request.setAttribute("page", page);
		request.setAttribute("listMap", listMap);
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String mapId = request.getParameter("mapId");
		Integer intMapId = (mapId != null && !mapId.isEmpty() && isNumber(mapId)) ? Integer.parseInt(mapId) : null;
		if(intMapId != null){
			ConnPoolUtil cp = ConnPoolImplUtil.getInstance();
			NodeImplLog nodeLog = new NodeImplLog(cp);
			List<NodeDto> listNode = nodeLog.getNodeByMapId(intMapId);
			nodeLog.releaseConnection();
			nodeLog.refreshConnection();
			JSONObject json = new JSONObject();
			listNode.forEach(e->{
				json.put(e.getNodeId(), e.getStatus());
			});
			System.out.println(json.toJSONString());
			response.getWriter().write(json.toJSONString());
		}else{
			response.getWriter().write("error");
		}
		
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
