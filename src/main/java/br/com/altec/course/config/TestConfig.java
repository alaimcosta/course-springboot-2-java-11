package br.com.altec.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.altec.course.entities.User;
import br.com.altec.course.repositories.UserRepository;

@Configuration
@Profile("test")//deve ser igual que ta configurado no properties
public class TestConfig implements CommandLineRunner{

	@Autowired 
	private UserRepository userRepository; //declaro um atributo do tipo Repository

	@Override
	public void run(String... args) throws Exception {

		User p1 = new User(null, "Alaim de Jesus", "alaim.costa@gmjail", "94585689", "125895");
		User p2 = new User(null, "Alailson", "ala.costa@gmjail", "599865889", "125895");
		
		//salvando no BD
		userRepository.saveAll(Arrays.asList(p1, p2));
	}
	
	
}
