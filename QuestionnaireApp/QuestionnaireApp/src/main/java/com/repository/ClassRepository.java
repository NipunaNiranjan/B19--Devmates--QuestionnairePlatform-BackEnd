package com.repository;


import com.model.NewClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<NewClass,Long> {
}
