package com.example.EventTimer.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

 @Entity
@Table(name="users")
 @Data

public class Entity_Class {
//	public Entity_Class(int id, String name, String email, String password, int createAt) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.createAt = createAt;
//	}

	@Id
	 @Column(name="id")
	private int id;
	 @Column(name="username")
	private String username;
	 @Column(name="email")
	private String email;
	 
     @Column(name="Password") 
	private String password;
@Column(name="createAt")
	private int createAt;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "datasync_id")
private CategoriesEntity_Class dataSync;
	
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "userId")
private List<EventEntity_Class> goals;





//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public int getCreateAt() {
//		return createAt;
//	} q
//
//	public void setCreateAt(int createAt) {
//		this.createAt = createAt;
//	}

 }