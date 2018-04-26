import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class input extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static String             url              = "jdbc:mysql://kwoksuncheng.ddns.net:3306/address";
   static String             user             = "kcheng";
   static String             password         = "2470Abcd";
   static Connection         connection       = null;
   static String query = null;
   Statement statement = null;

   public input() {
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
              
          // Take value from user input
	      String firstname = request.getParameter("firstName") ;
		  String lastName = request.getParameter("lastName") ;
		  String street1 = request.getParameter("street1") ;
		  String street2 = request.getParameter("street2") ;
		  String state = request.getParameter("state") ;	
		  String city = request.getParameter("city") ;	
		  String zip = request.getParameter("zip") ;	
		  String address = null;
		  if (street2 == null) 
		  {
			// insert input to the database if the user didn't type the street2
			  address = street1 + ", " + city + ", " + state + " " + zip;
		  }
		  else 
		  {
			// insert input to the database if the user typed the street2
			  address = street1 + " " + street2 + ", "+ city + ", " + state + " " + zip;
		  }
		  query = "INSERT INTO addressBook (firstName, lastName, address) VALUES ('" + firstname + "','"
				  + lastName + "','" + address + "')";
		  executeQuery(query);
		  // set a message and send it to the input page to let user know the adress has has been saved successfully
		  request.setAttribute("Message", "Address has been saved successfully!!");
		  request.getRequestDispatcher("/input.jsp").forward(request, response);        
		  
   }

   private void executeQuery(String query) {
	   try {
		   statement = connection.createStatement();
		   statement.execute(query);
	   }
	   catch (SQLException e) {		 
		   e.printStackTrace();		 
	   }	
   }   
}