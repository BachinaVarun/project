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
@WebServlet("/edit")
public class EmployeeEdit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=Integer.parseInt(req.getParameter("eid"));
    	String name=req.getParameter("ename");
    	String address=req.getParameter("eadd");
    	String email=req.getParameter("email");
    	String password=req.getParameter("epwd");
    	
    	Employee emp1=new Employee();
    	emp1.setEid(id);
    	emp1.setEname(name);
    	emp1.setEaddress(address);
    	emp1.setEmail(email);
    	emp1.setPassword(password);
    	
    	EmployeeDao ed1=new EmployeeDao();
    	Employee emp2=ed1.UpdateEmployee(emp1);
    	
    	if (emp2!=null) {
    		List<Employee> employees=ed1.getAllEmployees();
    		req.setAttribute("employees", employees);
//    		if(employees!=null) {
//    			req.setAttribute("employees", employees);
//    		}else {
    		
//    		req.setAttribute("empl", "empty");
//    		}
    		Cookie[] cookies=req.getCookies();
    		String value=null;
    		
    		
    		System.out.println(cookies);
    		for (Cookie cookie : cookies) {
				if(cookie.getName().equals("name")) {
					value=cookie.getValue();
				}
			}
    		req.setAttribute("Emp", value);
    		
    		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
    		dispatcher.forward(req, resp);
    	}
    }
}
