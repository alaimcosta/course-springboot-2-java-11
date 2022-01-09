package br.com.altec.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.altec.course.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}
