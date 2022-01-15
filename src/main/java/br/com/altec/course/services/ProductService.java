package br.com.altec.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.altec.course.entities.Product;
import br.com.altec.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() { // OPERAÇÃO NA CAMADA DE SERVIÇO
		return repository.findAll();
	}

	// chamar pelo ID
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
