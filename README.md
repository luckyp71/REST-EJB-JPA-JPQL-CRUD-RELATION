# REST-EJB-JPA-JPQL-CRUD-RELATION

This repository is just an example on how to create a REST provider as well as invoking them using HTTP protocol. These REST enable us to perform CRUD operations (including many to one relationship) using particular HTTP methods i.e. GET, POST, PUT, and DELETE.

List of URLs (assuming you run it on your local host with wildfly's default port 8080):

Department:
1. Return departments data with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/department/getDepartments
2. Return a department object with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/department/getDepartmentById?id=?
3. Add department (HTTP Method-> POST): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/department/addDepartment?name=?
4. Update department (HTTP Method-> PUT): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/department/updateDepartment?id=?&name=?
5. Delete department (HTTP Method-> DELETE): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/department/deleteDepartmentById?id=?

Employee:
1. Return employees data with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/employee/getEmployees
2. Return an employee object with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/employee/getEmployeeById?id=?
3. Add employee (HTTP Method-> POST): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/employee/addEmployee?name=?&age=?&dept_id=?
4. Update employee (HTTP Method-> PUT): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/employee/updateEmployee?id=?&name=?&age=?&dept_id=?
5. Delete employee (HTTP Method-> DELETE): http://localhost:8080/REST-EJB-JPA-JPQL-1.0-SNAPSHOT/rest/employee/deleteEmployeeById?id=?

Requirements:

1. Netbeans 8.1
2. Maven
3. Java EE
4. Java SE
5. EJB 3
6. Hibernate (JPA 2.1)
7. JPQL
8. JAX-RS
9. Wildfly 10.1.0.Final (Make sure you have created the required file and directory for adding MySQL's jdbc driver, configure the datasource name in standalone-full.xml inside your wildfly directory and put the datasource name defined in persistence.xml)
10. MySQL
