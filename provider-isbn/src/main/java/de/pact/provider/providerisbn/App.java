package de.pact.provider.providerisbn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class App {

	private BookDataService bookDataSevice = new BookDataService();

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookDataSevice.getBookById(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
