package com.example.EventTimer.Repository;
 
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventTimer.entity.Entity_Class;



 

@Repository
public interface Repository_Class extends JpaRepository<Entity_Class,Integer> {
 
	
	  public Page<Entity_Class> findAll(Pageable page);
	  
	  
	  public List<Entity_Class> findByUsernameStartsWith(String username);

		public List<Entity_Class> findByUsernameEndsWith(String username);

		public List<Entity_Class> findByUsernameContains(String username);

		public List<Entity_Class> findByUsernameContaining(int id);
		
}
