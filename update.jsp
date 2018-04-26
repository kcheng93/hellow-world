<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Your Address Book</title>
</head>
<body>
<h1>Address Book Update</h1>

<form action="update" method="POST">
	<div style="color: #FF0000;">${Message}</div>
      <table>
      	Please type the name you wnat to update.      	
        <tr>
          <td align="right">First name:</td>
          <td align="left"><input type="text" id="fName"
              name="firstName"/></td>
        </tr>
        <tr>
          <td align="right">Last name:</td>
          <td align="left"><input type="text"
              name="lastName"/></td>
        </tr>
       </table>
       
       <table>
        Please type New Address.
        <tr>
          <td align="right">Street 1:</td>
          <td align="left"><input type="text"
              name="street1"/></td>
        </tr>
        <tr>
          <td align="right">Street 2 (option):</td>
          <td align="left"><input type="text"
              name="street2"/></td>
        </tr>
        <tr>                 
          <td align="right">City:</td>
          <td align="left"><input type="text"
              name="city"/></td>
        </tr>
        <tr>
          <td align="right">State:</td>
          <td align="left"><input type="text"
              name="state"/></td>
        </tr>
        <tr>
          <td align="right">Zip-code:</td>
          <td align="left"><input type="text"
              name="zip"/></td>
        </tr>        
      </table>

      <p><input type="submit" value="Update"/> <a href="input.jsp">Address Book</a>  <a href="search.jsp">Search</a></p>
    </form>

</body>
</html>