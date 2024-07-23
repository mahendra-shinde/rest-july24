package com.mahendra.demo2;

import com.mahendra.demo2.models.Department;
import com.mahendra.demo2.models.DepartmentDAO;

import java.util.*;

import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.*;

@Path("/api/department")
@Produces("application/json")

public class DepartmentResource {

	private DepartmentDAO dao = new DepartmentDAO();
	
	@GET
	public List<Department> findAll(){
		return dao.getAll();
	}
	
	@GET
	@Path("/find")
	public Department findByNum(@QueryParam("deptno")String deptno) {
		return dao.findByDeptNum(deptno);
	}
	
	@POST
	@Consumes("application/json")
	public String create(Department dept) {
		try {
		dao.save(dept);
		return "Created new record";
		}catch(PersistenceException ex) {
			return "Error creating record: "+ex.getMessage();
		}
	}
	
	@DELETE
	public String deleteByNum(@QueryParam("deptno")String deptno) {
		try {
		dao.delete(deptno);
		return "Delete successful!";
		}catch(RuntimeException ex) {
			return(ex.getMessage());
		}
	}
	
	@PATCH
	public Department updateName(@QueryParam("deptno") String deptNo, @QueryParam("newdept") String newName) {
		return dao.update(deptNo, newName);
	}
	
	@PUT
	public Department update(Department dept) {
		return dao.update(dept.getDeptNo(), dept.getName());
	}
	
}
