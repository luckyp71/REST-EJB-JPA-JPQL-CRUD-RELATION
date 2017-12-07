package id.co.test.rest.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ejb.Stateless;

import id.co.test.rest.entity.Employee;
import id.co.test.rest.entity.Department;
import java.util.List;

@Stateless
public class EmployeeBean {

    @PersistenceContext(unitName = "testPU")
    EntityManager em;

    public boolean createEmployee(Employee e) {
        em.persist(e);
        return true;
    }

    public void addEmployee(String emp_name, String emp_age, String dept_id) {
        Employee emp = new Employee();

        Query q = em.createQuery("SELECT d FROM Department d WHERE d.department_id = :dept_id");
        q.setParameter("dept_id", Long.parseLong(dept_id));
        Department department = (Department) q.getSingleResult();

        emp.setEmployee_name(emp_name);
        emp.setEmployee_age(emp_age);
        emp.setDepartment(department);

        em.persist(emp);
    }

    public Object getEmployeeById(String emp_id) {
        Query q = em.createQuery("SELECT e.employee_name, e.employee_age, d.department_name FROM Employee e, Department d WHERE e.department = d.department_id AND e.employee_id = :emp_id");
        q.setParameter("emp_id", Long.parseLong(emp_id));
        Object e = (Object) q.getSingleResult();
        return e;
    }

    public void updateEmployee(String emp_id, String name, String age, String dept_id) {
        Query q = em.createQuery("UPDATE Employee e SET e.employee_name = :name, e.employee_age = :age, e.department = :dept_id WHERE e.employee_id = :emp_id");

        Query q1 = em.createQuery("SELECT d FROM Department d WHERE d.department_id = :dept_id");
        q1.setParameter("dept_id", Long.parseLong(dept_id));
        Department department = (Department) q1.getSingleResult();

        
        q.setParameter("emp_id", Long.parseLong(emp_id));
        q.setParameter("name", name);
        q.setParameter("age", age);
        q.setParameter("dept_id", department);
        q.executeUpdate();
    }

    public void deleteEmployeeById(String id) {
        Query q = em.createQuery("DELETE FROM Employee e WHERE e.employee_id = :id");
        q.setParameter("id", Long.parseLong(id));
        q.executeUpdate();
    }

    public List<Employee> getEmployees() {
        Query q = em.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q.getResultList();
        return employees;
    }
}
