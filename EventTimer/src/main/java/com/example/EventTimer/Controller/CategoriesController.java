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

import com.example.EventTimer.Service.Categoriesservice;
import com.example.EventTimer.entity.CategoriesEntity_Class;
 

@RestController
public class CategoriesController {

	@Autowired
	Categoriesservice service;
		 
	@GetMapping("/fetchempdataaa")
	public List<CategoriesEntity_Class> fetchEmpData() {
		return service.fetchDat();
	}

	@PostMapping("/insertdataaa")
	public CategoriesEntity_Class insertEmployeeDetails(@RequestBody CategoriesEntity_Class data) {
		return service.insertDat(data);
	}

	@DeleteMapping("deleterecordsbyiddd/{empId}")
	public String deleteRecordById(@PathVariable int empId) {
		return service.deleteRecord(empId);
	}
	
	
	@PutMapping("/updatedataaa/{empId}")
	public String updateExistingRecords(@PathVariable int empId,@RequestBody CategoriesEntity_Class data){
		
		return service.updateRecord(empId,data);
	}
}