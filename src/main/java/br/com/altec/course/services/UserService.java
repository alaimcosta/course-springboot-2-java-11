package br.com.altec.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.altec.course.entities.User;
import br.com.altec.course.repositories.UserRepository;
import br.com.altec.course.services.exceptions.DatabaseException;
import br.com.altec.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Inserindo usuarios no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Deletando
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) { //excessão de serviço
			throw new DatabaseException(e.getMessage()); //excessão de BD
		
		}
		
	}
	
	//Atualizar 
	//Recebo um usuário
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);//não vai no BD, só para ponitorar o objeto
			updateData(entity, obj);
			return repository.save(entity);	
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName()); //atualizar o nome
		entity.setEmail(obj.getEmail()); //email
		entity.setPhone(obj.getPhone()); //número de telefone
		
	}
}














