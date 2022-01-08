package br.com.altec.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.altec.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//criar um endpoits para testar/Controlador Rest que responde no caminho /users
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Alaim", "Alaim@gmail", "8888888", "122335");
		return ResponseEntity.ok().body(u);
	}
}
