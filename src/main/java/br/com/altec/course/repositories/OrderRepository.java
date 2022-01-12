package br.com.altec.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.altec.course.entities.Order;

//Order 
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
	
}
