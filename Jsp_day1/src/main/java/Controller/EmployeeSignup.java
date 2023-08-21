package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDao;
import DTO.Employee;
@WebServlet("/signup")
public class EmployeeSignup extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name=req.getParameter("ename");
    	String address=req.getParameter("eadd");
    	String email=req.getParameter("email");
    	String password=req.getParameter("epwd");
    	
    	Employee e1=new Employee();
    	e1.setEname(name);
    	e1.setEaddress(address);
    	e1.setEmail(email);
    	e1.setPassword(password);
    	
    	EmployeeDao ed1=new EmployeeDao();
        Employee em=ed1.saveEmployee(e1);
    	
    	if(em!=null) {
    		req.setAttribute("message", "Successfully signed up please login here");
    		
    		RequestDispatcher rq=req.getRequestDispatcher("Login.jsp");
    		rq.forward(req, resp);
    	}
    }
}
