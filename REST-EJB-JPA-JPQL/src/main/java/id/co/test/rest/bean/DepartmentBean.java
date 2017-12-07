package id.co.test.rest.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ejb.Stateless;

import id.co.test.rest.entity.Department;
import java.util.List;

@Stateless
public class DepartmentBean {
    
    @PersistenceContext(unitName="testPU")
    EntityManager em;
    
    public boolean createDepartment(Department dept){
        em.persist(dept);
        return true;
    }
    
    public void addDepartment(String name){
        Department d = new Department();
        d.setDepartment_name(name);
        em.persist(d);
    }
    
    public Department getDepartmentById(String dept_id){
        Query q = em.createQuery("SELECT d FROM Department d WHERE d.department_id = :dept_id");
        q.setParameter("dept_id", Long.parseLong(dept_id));
        Department d = (Department)q.getSingleResult();
        return d;
    }
    
    public void updateDepartment(String dept_id, String dept_name){
        Query q = em.createQuery("UPDATE Department d SET d.department_name = :dept_name WHERE d.department_id = :dept_id");
        q.setParameter("dept_id", Long.parseLong(dept_id));
        q.setParameter("dept_name", dept_name);
        q.executeUpdate();
    }
    
    public void deleteDepartmentById(String dept_id){
        Query q = em.createQuery("DELETE FROM Department d WHERE d.department_id = :dept_id");
        q.setParameter("dept_id", Long.parseLong(dept_id));
        q.executeUpdate();
    }
    
    public List<Department> getDepartments(){
        Query q = em.createQuery("SELECT d FROM Department d");
        List<Department> departments = q.getResultList();
        return departments;
    }
}
