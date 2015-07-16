package com.eachedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachedu.service.TestService;

@WebServlet(name="HelloServlet",urlPatterns="/hello.action",initParams={@WebInitParam(name="count_num",value="100")})
public class HelloServlet extends HttpServlet {

	private int countNum = 0;
	
	@Resource(name="java:comp/env/jdbc/datasource")
	private javax.sql.DataSource ds;
	
	@javax.inject.Named
	private TestService testService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		countNum = Integer.parseInt(config.getInitParameter("count_num"));
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printObj = response.getWriter();
		printObj.print("<p>我收到的参数是"+countNum+"</p>");
		try {
			printObj.print("<h1>#### ds:"+ds.getConnection().getCatalog()+"</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			printObj.print("<p>error:"+e.getMessage()+"</p>");
		}
		response.getWriter().flush();
	}

	
}
