package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DTO.Employee;


public class EmployeeDao {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("magician");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    
    
    public Employee saveEmployee(Employee emp) {
    	et.begin();
    	em.persist(emp);
    	et.commit();
    	return emp;
    }
    
    public Employee fetchbyemail(String email) {
    	Query q=em.createQuery("select e from Employee e where e.email=?1");
        q.setParameter(1, email);
        Employee emp1=(Employee) q.getSingleResult();
        return emp1;
    }
    public List<Employee> getAllEmployees(){
    	Query query=em.createQuery("select e from Employee e");
    	List<Employee> employees=query.getResultList();
    	return employees;
    }
    
    public boolean deleteEmployee(int id) {
    	Employee employee=em.find(Employee.class, id);
    	if (employee!=null) {
    		et.begin();
    		em.remove(employee);
    		et.commit();
    		return true;
    	}
    	return false;
    }
    
    public Employee getEmployeeById(int id) {
    	Employee emp=em.find(Employee.class, id);
    	return emp;
    }
    
    public Employee UpdateEmployee(Employee employee) {
    	et.begin();
    	em.merge(employee);
    	et.commit();
    	return employee;
    }
}
