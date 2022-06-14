package com.example.QuestionnaireApp.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.QuestionnaireApp.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByName(String name);
	
	List<Laptop> findByPrice(BigDecimal price);
	
	List<Laptop> findByBrand(String brand);
	
}
