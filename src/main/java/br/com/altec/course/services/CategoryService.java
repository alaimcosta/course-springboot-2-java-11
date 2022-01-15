package br.com.altec.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.altec.course.entities.Category;
import br.com.altec.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryService repository;

	public List<Category> findAll() { // OPERAÇÃO NA CAMADA DE SERVIÇO
		return repository.findAll();
	}

	// chamar pelo ID
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
