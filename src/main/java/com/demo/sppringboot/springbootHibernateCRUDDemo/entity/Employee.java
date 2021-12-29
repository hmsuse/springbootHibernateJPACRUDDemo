package com.demo.sppringboot.springbootHibernateCRUDDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(name="name")
	private String Name;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="mob")
	private String mob;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", password=" + password + ", email=" + email + ", mob=" + mob
				+ "]";
	}
	
	
	
	

	
	

}
