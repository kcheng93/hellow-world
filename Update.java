import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static String             url              = "jdbc:mysql://kwoksuncheng.ddns.net:3306/address";
   static String             user             = "kcheng";
   static String             password         = "2470Abcd";
   static Connection         connection       = null;
   static String query = null;
   Statement statement = null;
   static Boolean login = false;

   public Update() {
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
		  String street1 = request.getParameter("street1") ;
		  String street2 = request.getParameter("street2") ;
		  String state = request.getParameter("state") ;	
		  String city = request.getParameter("city") ;	
		  String zip = request.getParameter("zip") ;
		  Boolean found = false;	
		  
		  // Check the database whether or not it has a same eamil with user's input email
		  try {
			  	 // connect the database
			  	 String selectSQL = "SELECT * FROM addressBook";		         
		         Statement preparedStatement = connection.createStatement();		         
		         ResultSet rs = preparedStatement.executeQuery(selectSQL);
		         
		         while (rs.next()) {		        	
		            String tfname = rs.getString("firstName");
		            String tlname = rs.getString("lastName");	
		            
		            // compare the input name and name in the database to find the address
		            if(tfname.equalsIgnoreCase(fname) && tlname.equalsIgnoreCase(lname)) 
		            {
		            	String address = null;
		            	// find it and update the address in the database
		            	if(street2 == null) 
		            	{
		            		address = street1 + ", " + city + ", " + state + " " + zip;
		            	}
		            	else 
		            	{
		            		address = street1 + " " + street2 + ", "+ city + ", " + state + " " + zip;
		            	}		            	 
		            	selectSQL = "UPDATE addressBook SET address = '" + address + "' WHERE firstName = '" + fname + "' AND lastName = '" + lname + "'";
						Statement preparedStatement2 = connection.createStatement();
						preparedStatement2.executeUpdate(selectSQL);	
		            	//After update, send a message to user
		            	request.setAttribute("Message", "Address update successfully");
		            	found = true;		      		  	
		      		  	break;
		            }		            
		         }
		         if(!found)
		         {
		            	// Not find with the input name and display a message to user
		            	request.setAttribute("Message", "Address Not Found with the input name");		      		  	 
		         }
		         request.getRequestDispatcher("/update.jsp").forward(request, response);
		      } catch (SQLException e) {
		         e.printStackTrace();
		      	}
   }  
}