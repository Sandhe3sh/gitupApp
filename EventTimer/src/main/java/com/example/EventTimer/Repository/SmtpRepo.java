package com.example.EventTimer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventTimer.entity.SmtpEntity;

@Repository
public interface SmtpRepo extends JpaRepository<SmtpEntity, Integer>{

}
