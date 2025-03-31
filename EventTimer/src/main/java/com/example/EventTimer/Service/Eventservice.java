package com.example.EventTimer.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventTimer.Repository.EventRepository;
import com.example.EventTimer.entity.EventEntity_Class;

@Service
public class Eventservice {

	@Autowired
	EventRepository reposi;


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

	public List<EventEntity_Class> fetchE() {
		return reposi.findAll();
	}

	public EventEntity_Class insertD(EventEntity_Class data) {
		return reposi.save(data);
	}

	public String deleteR(int Id) {
		if (reposi.existsById(Id)) {
			reposi.deleteById(Id);
			return Id + "	Data deleted Successfully";
		} else {
			return Id + "Data Not Found";
		}
	}
	
	public String updateR(int Id,EventEntity_Class data){
		
		if(reposi.existsById(Id)) {
			reposi.save(data);
			return "Data updated Successfully";
		}
		else {
			return "Data not found";
		}
		
	}
	
	
}
