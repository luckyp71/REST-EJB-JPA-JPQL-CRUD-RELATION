package id.co.test.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

import id.co.test.rest.entity.Department;

@Entity
@Table(name="Employee")
@XmlRootElement(name="employee")
@XmlType(propOrder={"employee_id","employee_name","employee_age"})
public class Employee implements Serializable{
    
    @SequenceGenerator(name="EmployeeSeq",sequenceName="EmployeeSeq")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="EmployeeSeq")
    @Column(name="employee_id")
    private long employee_id;
    
    @Column(name="employee_name")
    private String employee_name;
    
    @Column(name="employee_age")
    private String employee_age;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    
    @XmlElement
    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    @XmlElement
    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    @XmlElement
    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }
    
    @XmlElement
    public Department getDepartment(){
        return department;
    }
    
    public void setDepartment(Department department){
        this.department = department;
    }
}
