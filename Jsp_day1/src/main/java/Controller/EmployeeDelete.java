package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDao;
import DTO.Employee;
@WebServlet("/delete")
public class EmployeeDelete extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=Integer.parseInt(req.getParameter("id"));
 	   
 	   EmployeeDao ed2=new EmployeeDao();
 	   boolean result=ed2.deleteEmployee(id);
 	   if (result) {
 		   List<Employee> employees=ed2.getAllEmployees();
 		   req.setAttribute("employees", employees);
 		   RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
 		   dispatcher.forward(req, resp);
 	   }
    }
}
