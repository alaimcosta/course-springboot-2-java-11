package br.com.altec.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.altec.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
	
}
