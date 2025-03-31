package com.example.EventTimer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventTimer.Service.Service_Class;
import com.example.EventTimer.entity.Entity_Class;
 

@RestController
public class Controller {

	@Autowired
	Service_Class service;
		 
	@GetMapping("/fetchempdata")
	public List<Entity_Class> fetchEmpData() {
		return service.fetchEmpData();
	}

	@PostMapping("/insertdata")
	public Entity_Class insertEmployeeDetails(@RequestBody Entity_Class data) {
		return service.insertData(data);
	}

	@DeleteMapping("deleterecordsbyid/{empId}")
	public String deleteRecordById(@PathVariable int empId) {
		return service.deleteRecords(empId);
	}
	
	
	@PutMapping("/updatedata/{empId}")
	public String updateExistingRecords(@PathVariable int empId,@RequestBody Entity_Class data){
		
		return service.updateRecords(empId,data);
	}
	
//	@GetMapping("/pagination")
//	public List<Entity_Class> fetchPageDetails(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String empnamesort){
//	
//		return service.fetchPage(pageno,pagesize,empnamesort);
//		
//	}
	
	@GetMapping("/startswith")
	public List<Entity_Class> fetchStartsWithRecords(@RequestParam String username){
		return service.startWithRecords(username);
	}
//	http://localhost:8080/endsswith?username=nu
	
	@GetMapping("/endsswith")
	public List<Entity_Class> fetchEndsWithRecords(@RequestParam String username){
		return service.endsWithRecords(username);
	}
	
	@GetMapping("/iscontains")
	public List<Entity_Class> fetchisContains(@RequestParam String username){
		return service.isContains(username);
	}
	
	@GetMapping("/containing")
	public List<Entity_Class> fetchContains(@RequestParam int id){
		return service.ContainingRecords(id);
	}
	
	@PostMapping("/smtp")
	public String saveSmtpData(@RequestParam String receiver,@RequestParam String subject,@RequestParam String mailBody) {
		return service.saveSmptp(receiver,subject,mailBody);
	}
	
}