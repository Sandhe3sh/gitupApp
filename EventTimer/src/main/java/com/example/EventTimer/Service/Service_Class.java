package com.example.EventTimer.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.EventTimer.Repository.Repository_Class;
import com.example.EventTimer.Repository.SmtpRepo;
import com.example.EventTimer.entity.Entity_Class;
import com.example.EventTimer.entity.SmtpEntity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class Service_Class {
	
	
	@Autowired
	Repository_Class repo;
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	SmtpRepo smtpRepo;
	 

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

	public List<Entity_Class> fetchEmpData() {
		return repo.findAll();
	}

	public Entity_Class insertData(Entity_Class data) {
		return repo.save(data);
	}

	public String deleteRecords(int empId) {
		if (repo.existsById(empId)) {
			repo.deleteById(empId);
			return empId + "	Data deleted Successfully";
		} else {
			return empId + "Data Not Found";
		}
	}
	
	public String updateRecords(int empId,Entity_Class data){
		
		if(repo.existsById(empId)) {
			repo.save(data);
			return "Data updated Successfully";
		}
		else {
			return "Data not found";
		}
		
	}
	
	



public List<Entity_Class> startWithRecords(String username) {
	
	return repo.findByUsernameStartsWith(username) ;
}
public List<Entity_Class> endsWithRecords(String username) {
	
	return repo.findByUsernameEndsWith(username);
}

public List<Entity_Class>isContains(String username) {
	
	return repo.findByUsernameContains(username);
}

public List<Entity_Class> ContainingRecords(int id) {
	
	return repo.findByUsernameContaining(id);
}


	

public String saveSmptp(String receiver, String subject, String mailBody) {
	
	try {
	MimeMessage msg = sender.createMimeMessage();
	
	MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
	
	msgHelper.setTo(receiver);
	msgHelper.setSubject(subject);
	msgHelper.setText(mailBody);
	sender.send(msg);
	
	SmtpEntity sentity = new SmtpEntity();
	
	sentity.setReceiver(receiver);
	sentity.setSubject(subject);
	sentity.setContent(mailBody);
	
	smtpRepo.save(sentity);
	
	return "Mail sent Successfully";
	
	
	}catch(MessagingException e) {
		return "Mail not sent"+e.getMessage();
	
	}
	
}

}
