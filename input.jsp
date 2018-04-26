<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Your Address Book</title>
</head>
<body>
<h1>Address Book</h1>

<form action="input" method="POST">
      <table>
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

      <p><input type="submit" value="Save"/> <a href="search.jsp">Search</a>  <a href="update.jsp">Update</a></p>
    </form>

</body>
</html>