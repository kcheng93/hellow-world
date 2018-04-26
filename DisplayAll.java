import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayAll")
public class DisplayAll extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static String             url              = "jdbc:mysql://kwoksuncheng.ddns.net:3306/address";
   static String             user             = "kcheng";
   static String             password         = "2470Abcd";
   static Connection         connection       = null;
   static String query = null;
   Statement statement = null;
   static Boolean login = false;

   public DisplayAll() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html;charset=UTF-8");
	      
	   	 // Connect to the MySQL database
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
                 
	      } catch (ClassNotFoundException e) {	         
	         e.printStackTrace();
	         return;
	      }	      
	      connection = null;
	      try {
	         connection = DriverManager.getConnection(url, user, password);
                 
	      } catch (SQLException e) {	         
	         e.printStackTrace();
	         return;
	      }
	      if (connection != null) {	         
                
	      } else {
	         System.out.println("Failed to make connection!");                 
	      }
	      
		  try {
			  	 // connect the database
		         String selectSQL = "SELECT * FROM addressBook";		         
		         Statement preparedStatement = connection.createStatement();		         
		         ResultSet rs = preparedStatement.executeQuery(selectSQL);
		         response.getWriter().println("----------------------------------------------------------------------------------------------<br>");
		         response.getWriter().println("|       ID       |       First Name       |       Last Name       |                   Address                 |<br>");
		         response.getWriter().println("----------------------------------------------------------------------------------------------<br>");
		         while (rs.next()) {		        	
		        	 response.getWriter().println("|       " + rs.getInt("id") + "       |       " + rs.getString("firstName") + "       |       " + rs.getString("lastName") + "       |                  " 
		         + rs.getString("address") + "                 |<br>");
		         }
		         response.getWriter().println("----------------------------------------------------------------------------------------------<br>");
		         response.getWriter().println("<a href=\"search.jsp\">Back</a></p>");
		      } catch (SQLException e) {
		         e.printStackTrace();
		  }
   }  
}