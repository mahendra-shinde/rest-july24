package com.mahendra.demo2.models;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {
	@Id
	@Column(name="dept_no",length = 4)
	private String deptNo;
	
	@Column(name="dept_name", length=40)
	private String name;

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String deptNo, String name) {
		super();
		this.deptNo = deptNo;
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
