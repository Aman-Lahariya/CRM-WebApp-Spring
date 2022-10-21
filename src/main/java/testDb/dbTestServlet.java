package testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbTestServlet
 */
@WebServlet("/dbTestServlet")
public class dbTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String dbURL = "jdbc:mysql://127.0.0.1:3307/web_customer_tracker?useSSL=false";
    	String userName = "springstudent";
    	String pass = "springstudent";
    	String driver = "com.mysql.cj.jdbc.Driver";
    	
    	try {
    		
    		PrintWriter out = response.getWriter();
    		out.println("\nConnecting to databse!!");
    		//Loads driver
    		Class.forName(driver);
    		Connection conn = DriverManager.getConnection(dbURL, userName, pass);
    		out.println("DB connection successful!!");
    		conn.close();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
		
		
	}

}
