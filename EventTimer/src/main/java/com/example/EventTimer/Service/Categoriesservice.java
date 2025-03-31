//package com.example.EventTimer.Service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.EventTimer.Repository.Categoriesrepository;
//import com.example.EventTimer.entity.CategoriesEntity_Class;
// 
// 
//
//@Service
//public class Categoriesservice {
//
//	@Autowired
//	Categoriesrepository repos;
//	
//	
//	
//	public static void main(String[] args) {
//
//		String url = "jdbc:mysql://localhost:3306/event_details";
//		String username = "root";
//		String password = "root";
//
//		try (Connection con = DriverManager.getConnection(url, username, password)) {
//			if (con != null) {
//				System.out.println("Connection established successfully");
//			} else {
//				System.out.println("Failed to conect db");
//			}
//
//		} catch (SQLException exp) {
//
//			System.out.println("connection failed" + exp.getMessage());
//
//		}
//
//	}
//	public List<CategoriesEntity_Class>fetchEmpData(){
//		return repos.findAll();
//				}
//    
//	
//	 
//	public CategoriesEntity_Class insertData(CategoriesEntity_Class data) {
//		return repos.save(data);
//	}
//
//	public String deleteRecords(int empId) {
//		if (repos.existsById(empId)) {
//			repos.deleteById(empId);
//			return empId + "	Data deleted Successfully";
//		} else {
//			return empId + "Data Not Found";
//		}
//	}
//	
//	public String updateRecords(int empId,CategoriesEntity_Class data){
//		
//		if(repos.existsById(empId)) {
//			repos.save(data);
//			return "Data updated Successfully";
//		}
//		else {
//			return "Data not found";
//		}
//		
//	}
//	
//	
//}
//
//


package com.example.EventTimer.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventTimer.Repository.Categoriesrepository;
import com.example.EventTimer.entity.CategoriesEntity_Class;

@Service
public class Categoriesservice {
	
	
	@Autowired
	Categoriesrepository repos;


	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/event_details";
		String username = "root";
		String password = "root";

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			if (con != null) {
				System.out.println("Connection established successfully");
			} else {
				System.out.println("Failed to conect db");
			}

		} catch (SQLException exp) {

			System.out.println("connection failed" + exp.getMessage());

		}

	}

	public List<CategoriesEntity_Class> fetchDat() {
		return repos.findAll();
	}

	public CategoriesEntity_Class insertDat(CategoriesEntity_Class data) {
		return repos.save(data);
	}

	public String deleteRecord(int Id) {
		if (repos.existsById(Id)) {
			repos.deleteById(Id);
			return Id + "	Data deleted Successfully";
		} else {
			return Id + "Data Not Found";
		}
	}
	
	public String updateRecord(int Id,CategoriesEntity_Class data){
		
		if(repos.existsById(Id)) {
			repos.save(data);
			return "Data updated Successfully";
		}
		else {
			return "Data not found";
		}
		
	}
	
	
}
