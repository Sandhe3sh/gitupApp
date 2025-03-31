package com.example.EventTimer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="categories")
@Data
public class CategoriesEntity_Class {

	@Id
	 @Column(name="id")
	private int id;
	 @Column(name="name")
	private String name;
}
