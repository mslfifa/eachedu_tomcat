package com.eachedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HelloServlet",urlPatterns="/hello.action",initParams={@WebInitParam(name="count_num",value="100")})
public class HelloServlet extends HttpServlet {

	private int countNum = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		countNum = Integer.parseInt(config.getInitParameter("count_num"));
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter print = response.getWriter();
		print.print("<p>我收到的参数是"+countNum+"</p>");
		try {
			Context ctx = (Context) new InitialContext();
			if(ctx!=null){
				javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("java:comp/env/jdbc/datasource");
				System.out.println("#### ds:"+ds);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print.println("<p><font color='red'>出错了:"+e.getMessage()+"</font></p>");
		}
		response.getWriter().flush();
	}

	
}
