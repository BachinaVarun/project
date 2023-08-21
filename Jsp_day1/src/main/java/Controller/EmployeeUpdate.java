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

@WebServlet("/update")
public class EmployeeUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int id=Integer.parseInt(req.getParameter("id"));
    	EmployeeDao emd=new EmployeeDao();
    	Employee employee=emd.getEmployeeById(id);
    	if (employee!=null) {
    		req.setAttribute("emp3", employee);
    		RequestDispatcher disp=req.getRequestDispatcher("edit.jsp");
    		disp.forward(req, resp);
    	}
    	else {
    		req.setAttribute("message", "Login first to update");
    		RequestDispatcher dis=req.getRequestDispatcher("Login.jsp");
    		dis.forward(req, resp);
    	}
    }
}
