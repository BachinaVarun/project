<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <% 
   String message=(String)request.getAttribute("message");
   if(message !=null) {
   %>
   <h3><%=message%></h3>
   <%
   }%>
  <form action="login" method="post">
   <table>
     <tr>
         <td><label>EmployeeEmail:</label></td>
         <td><input type="email" name="email" placeholder="Enter the Employee email"></td>
       </tr>
       <tr>
         <td><label>EmployeePassword:</label></td>
         <td><input type="password" name="epwd" placeholder="Enter the Employee Password"></td>
       </tr>
       <tr>
         <td><input type="submit" value="Login"></td>
       </tr>
   </table>
  </form>
</body>
</html>