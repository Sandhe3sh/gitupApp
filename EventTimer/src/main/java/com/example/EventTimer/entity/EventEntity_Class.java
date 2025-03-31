package com.example.EventTimer.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="events")
@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
public class EventEntity_Class {

	@Id
	@Column(name="id")
	private int id;
	 @Column(name="name")
	private String name;
	 @Column(name="description")
	 private String description;
	 @Column(name="eventDateTime")
	 private Date eventDateTime;
	 

}
