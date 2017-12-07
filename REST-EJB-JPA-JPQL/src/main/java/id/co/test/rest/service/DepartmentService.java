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

import id.co.test.rest.entity.Department;
import id.co.test.rest.bean.DepartmentBean;

import java.util.List;

@Path("department")
public class DepartmentService {

    @EJB
    DepartmentBean deptBean;

    private final String status = "{\"status\":\"ok\"}";

    @POST
    @Path("addDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDepartment(
            @QueryParam("name") String name
    ) {
        deptBean.addDepartment(name);
        return Response.status(200).entity(status).build();
    }

    @GET
    @Path("getDepartmentById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentByIdJSON(
            @QueryParam("id") String id
    ) {
        Department dept = deptBean.getDepartmentById(id);
        return Response.status(200).entity(dept).build();
    }

    @GET
    @Path("getDepartments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartmentsJSON() {
        List<Department> depts = deptBean.getDepartments();
        return depts;
    }
    
    @PUT
    @Path("updateDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDepartment(
            @QueryParam("id")String id,
            @QueryParam("name")String name
    ){
        deptBean.updateDepartment(id, name);
        return Response.status(200).entity(status).build();
    }
    
    @DELETE
    @Path("deleteDepartmentById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDepartment(
            @QueryParam("id")String id,
            @QueryParam("name")String name
    ){
        deptBean.deleteDepartmentById(id);
        return Response.status(200).entity(status).build();
    }
}
