<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="signup" method="post">
     <table>
       <tr>
         <td><label>EmployeeId:</label></td>
         <td><input type="number" name="eid" placeholder="Enter the Employeeid"></td>
       </tr>
       <tr>
         <td><label>EmployeeName:</label></td>
         <td><input type="text" name="ename" placeholder="Enter the Employeename"></td>
       </tr>
       <tr>
         <td><label>EmployeeAddress:</label></td>
         <td><input type="text" name="eadd" placeholder="Enter the EmployeeAddress"></td>
       </tr>
       <tr>
         <td><label>EmployeeEmail:</label></td>
         <td><input type="email" name="email" placeholder="Enter the Employee email"></td>
       </tr>
        <tr>
         <td><label>EmployeePassword:</label></td>
         <td><input type="password" name="epwd" placeholder="Enter the Employee Password"></td>
       </tr>
        <tr>
         <td><input type="submit" value="Signup"></td>
       </tr>
     </table>
   </form>
</body>
</html>