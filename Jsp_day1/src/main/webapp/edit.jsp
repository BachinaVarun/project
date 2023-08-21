<%@page import="DTO.Employee"%>
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
      Employee employee= (Employee) request.getAttribute("emp3");
	%>
	<form action="edit" method="post">
		<table>
			<tr>
				<td><label>EmployeeId:</label></td>
				<td><input type="hidden" name="eid"
					placeholder="Enter the Employeeid" value="<%=employee.getEid() %>" readonly="true"></td>
			</tr>
			
			<tr>
				<td><label>EmployeeName:</label></td>
				<td><input type="text" name="ename" value="<%=employee.getEname()%>"
					placeholder="Enter the Employeename"></td>
			</tr>
			<tr>
				<td><label>EmployeeAddress:</label></td>
				<td><input type="text" name="eadd" value="<%=employee.getEaddress() %>"
					placeholder="Enter the EmployeeAddress"></td>
			</tr>
			<tr>
				<td><label>EmployeeEmail:</label></td>
				<td><input type="email" name="email" value="<%=employee.getEmail() %>"
					placeholder="Enter the Employee email"></td>
			</tr>
			<tr>
				<td><label>EmployeePassword:</label></td>
				<td><input type="password" name="epwd" value="<%=employee.getPassword() %>"
					placeholder="Enter the Employee Password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>