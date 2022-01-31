package br.com.altec.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.altec.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	
	
}
