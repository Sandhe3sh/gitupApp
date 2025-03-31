package com.example.EventTimer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventTimer.entity.CategoriesEntity_Class;
import com.example.EventTimer.entity.EventEntity_Class;

@Repository
public interface EventRepository extends JpaRepository<EventEntity_Class,Integer> {

}

