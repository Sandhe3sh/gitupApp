package com.example.EventTimer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventTimer.entity.CategoriesEntity_Class;
 

@Repository
public interface Categoriesrepository extends JpaRepository<CategoriesEntity_Class,Integer> {

}
