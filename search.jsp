<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Your Address Book</title>
</head>
<body>
<h1>Address Book Search</h1>

<form action="search" method="POST">
      <table>
      	Please type the name you wnat to search.
      	<div style="color: #FF0000;">${Message}</div>
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
      
      <div style="color: #FF0000;">${Title}</div>
      <div>${Name}</div>
      <div>${address}</div>

      <p><input type="submit" value="Search"/> <a href="input.jsp">Address Book</a>  <a href="update.jsp">Update</a>  <a href="displayAll">Display All</a></p>
    </form>

</body>
</html>