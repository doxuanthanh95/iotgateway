package iot.gateway.bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iot.gateway.coap.GatewayCoap;

@WebServlet(name = "DashboardBus", urlPatterns = "/dashboard")
public class DashboardBus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DashboardBus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException{
		GatewayCoap.getInfoFromServer();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("serial")
		HashMap<String, String> page = new HashMap<String, String>(){{
			put("title", "Dashboard"); put("layout", "layout/dashboard.jsp");}
		};
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}

}
