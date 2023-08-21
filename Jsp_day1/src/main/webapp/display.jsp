<%@page import="DTO.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%String name=(String)request.getAttribute("key");
    if (name!=null){
    %>
    <h3>Changed by
     <%=name%></h3>
     <%
     }
     %>
	<%!List<Employee> li;%>
	<%
	li = (List) request.getAttribute("employees");
	%>
	<%= request.getAttribute("empl") %>
	<table border="1px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		for (Employee e : li) {
		%>
		<tr>
			<td><%=e.getEid()%></td>
			<td><%=e.getEname()%></td>
			<td><%=e.getEaddress()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><a href="delete?id=<%= e.getEid()%>"><button>Delete</button></a></td>
			<td><a href="update?id=<%= e.getEid() %>"><button>Update</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>