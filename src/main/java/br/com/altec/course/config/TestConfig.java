package br.com.altec.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.altec.course.entities.Category;
import br.com.altec.course.entities.Order;
import br.com.altec.course.entities.Product;
import br.com.altec.course.entities.User;
import br.com.altec.course.entities.enums.OrderStatus;
import br.com.altec.course.repositories.CategoryRepository;
import br.com.altec.course.repositories.OrderRepository;
import br.com.altec.course.repositories.ProductRepository;
import br.com.altec.course.repositories.UserRepository;

@Configuration
@Profile("test")//deve ser igual que ta configurado no properties
public class TestConfig implements CommandLineRunner{

	//AQUI FAÇO A INJEÇÃO DE DEPENDECIAS NO BD
	@Autowired 
	private UserRepository userRepository; //declaro um atributo do tipo Repository
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Instâncio os objetos
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//agora calvo no banco
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		//Salvar produto no banco
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		//salvar as associações
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		
		
		User pes1 = new User(null, "Alaim de Jesus", "alaim.costa@gmjail", "94585689", "125895");
		User pes2 = new User(null, "Alailson", "ala.costa@gmjail", "599865889", "125895");
		
		Order o1 = new Order(null, Instant.parse("2022-01-05T05:56:07Z"), OrderStatus.PAID, pes1);
		Order o2 = new Order(null, Instant.parse("2022-01-07T05:56:07Z"), OrderStatus.WAITING_PAYMENT, pes2);
		Order o3 = new Order(null, Instant.parse("2022-01-09T05:56:10Z"), OrderStatus.WAITING_PAYMENT, pes1);
		
		userRepository.saveAll(Arrays.asList(pes1, pes2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); 	// Aqui passo a lista de pedidos 
	
		//salvando no BD
		//userRepository.saveAll(Arrays.asList(p1, p2));
	}
	
	
}
