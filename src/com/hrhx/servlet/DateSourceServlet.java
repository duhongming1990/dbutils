package com.hrhx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import javax.sql.DataSource;

/* 
 name == <servlet-name> 
 urlPatterns == <url-pattern>, 
 loadOnStartup == <load-on-startup> 
 initParam == <init-param> 
 name == <param-name> 
 value == <param-value> 
 */
@WebServlet(name = "DateSourceServlet", urlPatterns = { "/TestDateSource" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "DATA_SOURCE_DBCP_ORACLE", value = "java:comp/env/jdbc/dbcp_oracle"),
		@WebInitParam(name = "DATA_SOURCE_DBCP_MYSQL", value = "java:comp/env/jdbc/dbcp_mysql"),
		@WebInitParam(name = "DATA_SOURCE_DBCP_SQLSERVER", value = "java:comp/env/jdbc/dbcp_sqlserver"),
		@WebInitParam(name = "DATA_SOURCE_DBCP_POSTGRES", value = "java:comp/env/jdbc/dbcp_postgres"),
		
		@WebInitParam(name = "DATA_SOURCE_C3P0_ORACLE", value = "java:comp/env/jdbc/c3p0_oracle"),
		@WebInitParam(name = "DATA_SOURCE_C3P0_MYSQL", value = "java:comp/env/jdbc/c3p0_mysql"),
		@WebInitParam(name = "DATA_SOURCE_C3P0_SQLSERVER", value = "java:comp/env/jdbc/c3p0_sqlserver"),
		@WebInitParam(name = "DATA_SOURCE_C3P0_POSTGRES", value = "java:comp/env/jdbc/c3p0_postgres"),
		
		@WebInitParam(name = "DATA_SOURCE_DRUID_ORACLE", value = "java:comp/env/jdbc/druid_oracle"),
		@WebInitParam(name = "DATA_SOURCE_DRUID_MYSQL", value = "java:comp/env/jdbc/druid_mysql"),
		@WebInitParam(name = "DATA_SOURCE_DRUID_SQLSERVER", value = "java:comp/env/jdbc/druid_sqlserver"),
		@WebInitParam(name = "DATA_SOURCE_DRUID_POSTGRES", value = "java:comp/env/jdbc/druid_postgres")})
public class DateSourceServlet extends HttpServlet {
	
	private static final String DATA_SOURCE_DBCP_ORACLE = "java:comp/env/jdbc/dbcp_oracle";
	private static final String DATA_SOURCE_DBCP_MYSQL = "java:comp/env/jdbc/dbcp_mysql";
	private static final String DATA_SOURCE_DBCP_SQLSERVER = "java:comp/env/jdbc/dbcp_sqlserver";
	private static final String DATA_SOURCE_DBCP_POSTGRES = "java:comp/env/jdbc/dbcp_postgres";
	
	private static final String DATA_SOURCE_C3P0_ORACLE = "java:comp/env/jdbc/c3p0_oracle";
	private static final String DATA_SOURCE_C3P0_MYSQL = "java:comp/env/jdbc/c3p0_mysql";
	private static final String DATA_SOURCE_C3P0_SQLSERVER = "java:comp/env/jdbc/c3p0_sqlserver";
	private static final String DATA_SOURCE_C3P0_POSTGRES = "java:comp/env/jdbc/c3p0_postgres";
	
	private static final String DATA_SOURCE_DRUID_ORACLE = "java:comp/env/jdbc/druid_oracle";
	private static final String DATA_SOURCE_DRUID_MYSQL = "java:comp/env/jdbc/druid_mysql";
	private static final String DATA_SOURCE_DRUID_SQLSERVER = "java:comp/env/jdbc/druid_sqlserver";
	private static final String DATA_SOURCE_DRUID_POSTGRES = "java:comp/env/jdbc/druid_postgres";
	
	
	
	private static final long serialVersionUID = -5741080764997900914L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{  
        request.setCharacterEncoding("GBK");  
        ServletConfig config = getServletConfig();  
        PrintWriter out = response.getWriter();  
        
        Context ctx;
        DataSource ds;
		try {
			ctx = new InitialContext();
			out.println("===============================DBCP=================================="); 
			//DBCP-Oracle
			out.println(config.getInitParameter("DATA_SOURCE_DBCP_ORACLE")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DBCP_ORACLE);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			//DBCP-Mysql
			out.println(config.getInitParameter("DATA_SOURCE_DBCP_MYSQL")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DBCP_MYSQL);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			//DBCP-SqlServer
			out.println(config.getInitParameter("DATA_SOURCE_DBCP_SQLSERVER")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DBCP_SQLSERVER);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			//DBCP-Postgres
			out.println(config.getInitParameter("DATA_SOURCE_DBCP_POSTGRES")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DBCP_POSTGRES);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			out.println("===============================C3P0=================================="); 
			//C3P0-Oracle
			out.println(config.getInitParameter("DATA_SOURCE_C3P0_ORACLE")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_C3P0_ORACLE);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			//C3P0-Mysql
			out.println(config.getInitParameter("DATA_SOURCE_C3P0_MYSQL")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_C3P0_MYSQL);
			out.println(ds);
			out.println(ds.getConnection());
			out.println(); 
			//C3P0-SqlServer
			out.println(config.getInitParameter("DATA_SOURCE_C3P0_SQLSERVER")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_C3P0_SQLSERVER);
			out.println(ds); 
			out.println(ds.getConnection());
			out.println(); 
			//DBCP-Postgres
			out.println(config.getInitParameter("DATA_SOURCE_C3P0_POSTGRES")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_C3P0_POSTGRES);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			out.println("===============================DRUID=================================="); 
			//DBCP-Oracle
			out.println(config.getInitParameter("DATA_SOURCE_DRUID_ORACLE")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DRUID_ORACLE);
			out.println(ds); 
			out.println(ds.getConnection());
			out.println(); 
			//DRUID-Mysql
			out.println(config.getInitParameter("DATA_SOURCE_DRUID_MYSQL")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DRUID_MYSQL);
			out.println(ds);  
			//out.println(ds.getConnection());
			out.println(); 
			//DRUID-SqlServer
			out.println(config.getInitParameter("DATA_SOURCE_DRUID_SQLSERVER")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DRUID_SQLSERVER);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			//DRUID-Postgres
			out.println(config.getInitParameter("DATA_SOURCE_DRUID_POSTGRES")); 
			ds = (DataSource) ctx.lookup(DATA_SOURCE_DRUID_POSTGRES);
			out.println(ds);  
			out.println(ds.getConnection());
			out.println(); 
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}
