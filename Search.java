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

@WebServlet("/search")
public class Search extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static String             url              = "jdbc:mysql://kwoksuncheng.ddns.net:3306/address";
   static String             user             = "kcheng";
   static String             password         = "2470Abcd";
   static Connection         connection       = null;
   static String query = null;
   Statement statement = null;
   

   public Search() {
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
              
          // Take values from user input	      
		  String fname = request.getParameter("firstName") ;
		  String lname = request.getParameter("lastName") ;
		  Boolean found = false;
		  // Check the database whether or not it has a same eamil with user's input email
		  try {
			  	 // connect the database
		         String selectSQL = "SELECT * FROM addressBook";		         
		         Statement preparedStatement = connection.createStatement();		         
		         ResultSet rs = preparedStatement.executeQuery(selectSQL);
		         
		         while (rs.next()) {		        	
		            // compare the input name and name in the database to find the address
		            if(fname.equalsIgnoreCase(rs.getString("firstName")) && lname.equalsIgnoreCase(rs.getString("lastName"))) 
		            {
		            	// find it and display the address to the search page
		            	request.setAttribute("Title", "Found it here is your result:");
		            	request.setAttribute("Name", fname + " " + lname);
		            	request.setAttribute("address", rs.getString("address"));		            		
		            	found = true;
		            	break;
		            }		            
		         }
		         if(!found) 
		         {
		           // Not find it and display a message to user
		           request.setAttribute("Message", "Address Not Found");
		         }		         
		         request.getRequestDispatcher("/search.jsp").forward(request, response);
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		  }
   }  
}