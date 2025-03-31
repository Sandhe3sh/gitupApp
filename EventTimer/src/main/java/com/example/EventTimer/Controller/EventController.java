package com.example.EventTimer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventTimer.Service.Eventservice;
import com.example.EventTimer.entity.EventEntity_Class;
 

@RestController
public class EventController {

	@Autowired
	 Eventservice service;
		 
	@GetMapping("/fetchempdataa")
	public List<EventEntity_Class> fetchEmpData() {
		return service.fetchE();
	}

	@PostMapping("/insertdataa")
	public EventEntity_Class insertEmployeeDetails(@RequestBody EventEntity_Class data) {
		return service.insertD(data);
	}

	@DeleteMapping("deleterecordsbyidd/{empId}")
	public String deleteRecordById(@PathVariable int empId) {
		return service.deleteR(empId);
	}
	
	
	@PutMapping("/updatedataa/{empId}")
	public String updateExistingRecords(@PathVariable int empId,@RequestBody EventEntity_Class data){
		
		return service.updateR(empId,data);
	}
}