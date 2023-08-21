package Controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDao;
import DTO.Employee;

@WebServlet("/login")
public class EmployeeLogin extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String dbmail=req.getParameter("email");
    	String dbpassword=req.getParameter("epwd");
    	
    	EmployeeDao ed2=new EmployeeDao();
    	Employee edb=ed2.fetchbyemail(dbmail);
    	
    	if (dbmail.equals(edb.getEmail())&& dbpassword.equals(edb.getPassword())){
    		List<Employee> employees=ed2.getAllEmployees();
    		req.setAttribute("employees", employees);
    		Cookie cookie=new Cookie("key", edb.getEname());
    		resp.addCookie(cookie);
    		
    		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
    		dispatcher.forward(req, resp);
    	}
    	else {
    		req.setAttribute("message", "Invalid Email or Password Please Enter correct Email or Password");
    		RequestDispatcher re1=req.getRequestDispatcher("Login.jsp");
    		re1.include(req, resp);
    	}
    }  
}
