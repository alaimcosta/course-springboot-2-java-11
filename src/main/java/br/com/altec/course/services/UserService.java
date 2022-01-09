package br.com.altec.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.altec.course.entities.User;
import br.com.altec.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() { // OPERAÇÃO NA CAMADA DE SERVIÇO
		return repository.findAll();
	}

	// chamar pelo ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
