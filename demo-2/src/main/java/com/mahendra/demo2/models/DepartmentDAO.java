package com.mahendra.demo2.models;

import com.mahendra.demo2.JPAContext;
import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class DepartmentDAO {

	private JPAContext context = JPAContext.getContext();
	
	public boolean save(Department dept) {
		EntityManager em = context.createEntityManager();
		EntityTransaction tn =null;
		try {
			tn = em.getTransaction();
			tn.begin();
			em.persist(dept);
			tn.commit();
			System.out.println("Record created");
		}catch(PersistenceException ex) {
			if(tn!=null) {
				System.out.println("Error "+ex.getMessage());
				tn.rollback();
			}
			return false;
		}finally {
			em.close();
		}
		return true;		
	}
	
	public List<Department> getAll(){
		List<Department> depts = new LinkedList<Department>();
		EntityManager em = context.createEntityManager();
		TypedQuery<Department> query = em.createQuery("from Department d", Department.class);
		return query.getResultList();
	}
	
	public Department findByDeptNum(String deptNo) {
		EntityManager em = context.createEntityManager();
		Department dept = em.find(Department.class, deptNo);
		em.close();
		return dept;
	}
	public Department update(String deptNo, String newName) {
		EntityManager em = context.createEntityManager();
		Department dept = em.find(Department.class, deptNo);
		dept.setName(newName);
		EntityTransaction tn = null;
		try {
			tn = em.getTransaction();
			tn.begin();
			em.merge(dept);
			tn.commit();
			System.out.println("Record updated!");
			return dept;
		}catch(PersistenceException ex) {
			if(tn!=null) {
				System.out.println("Error "+ex.getMessage());
				tn.rollback();
			}
			return null;
		}finally {
			em.close();
		}
	}
	
	public void delete(String deptNo) {
		EntityManager em = context.createEntityManager();
		Department dept = em.find(Department.class, deptNo);
		
		EntityTransaction tn = null;
		try {
			tn = em.getTransaction();
			tn.begin();
			em.remove(dept);
			tn.commit();
			System.out.println("Record deleted!");
			
		}catch(PersistenceException ex) {
			if(tn!=null) {
				System.out.println("Error "+ex.getMessage());
				tn.rollback();
			}
			throw new RuntimeException("Cannot delete "+ex.getMessage());
		}finally {
			em.close();
		}
	}
	
}
