package com.mahendra.demo2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAContext {

	private static JPAContext context = new JPAContext();
	private EntityManagerFactory factory = null;
	
	private JPAContext() {
		factory = Persistence.createEntityManagerFactory("pu1");
	}
	
	public static JPAContext getContext() {
		return context;
	}
	
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
}
