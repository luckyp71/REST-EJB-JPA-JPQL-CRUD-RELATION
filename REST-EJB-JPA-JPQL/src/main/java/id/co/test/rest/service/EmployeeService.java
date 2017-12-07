package id.co.test.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ejb.EJB;

import id.co.test.rest.entity.Employee;
import id.co.test.rest.bean.EmployeeBean;

import java.util.List;

@Path("employee")
public class EmployeeService {
    
    @EJB
    EmployeeBean empBean;
    
    private final String status = "{\"status\":\"ok\"}";
    
    @POST
    @Path("addEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(
            @QueryParam("name")String emp_name,
            @QueryParam("age")String emp_age,
            @QueryParam("dept_id")String dept_id
    ){
        empBean.addEmployee(emp_name, emp_age, dept_id);
        return Response.status(200).entity(status).build();
    }
   
    @GET
    @Path("getEmployeeById")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getEmployeeByIdJSON(
            @QueryParam("id")String id
    ){
        Object e = empBean.getEmployeeById(id);
        return e;
    }
    
    @GET
    @Path("getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesJSON(){
        List<Employee> employees =  empBean.getEmployees();
        return employees;
    }
    
    @PUT
    @Path("updateEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(
            @QueryParam("id")String id,
            @QueryParam("name")String name,
            @QueryParam("age")String age,
            @QueryParam("dept_id")String dept_id
    ){
        empBean.updateEmployee(id, name, age, dept_id);
        return Response.status(200).entity(status).build();
    }
    
    @DELETE
    @Path("deleteEmployeeById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delteEmployee(
            @QueryParam("id")String id
    ){
        empBean.deleteEmployeeById(id);
        return Response.status(200).entity(status).build();
    }
}
