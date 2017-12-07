package id.co.test.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

@Entity
@Table(name="Department")
@XmlRootElement(name="department")
@XmlType(propOrder={"department_id","department_name"})
public class Department implements Serializable{
    
    @SequenceGenerator(name="DepartmentSeq", sequenceName="DepartmentSeq")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "DepartmentSeq")
    @Column(name="department_id")
    private long department_id;
    
    @Column(name="department_name")
    private String department_name;

    @XmlElement
    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    @XmlElement
    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
   
}
