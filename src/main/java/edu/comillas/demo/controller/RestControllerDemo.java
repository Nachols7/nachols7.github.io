package edu.comillas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.demo.model.User;
import edu.comillas.demo.service.MovieService;

@RestController
@RequestMapping("/api")
public class RestControllerDemo {

	@Autowired
	private MovieService movieService;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody String message) {
		System.out.print(message);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/user/")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		return new ResponseEntity<>("El nombre de usuario es " + user.getUsername(), HttpStatus.OK);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		final User user = new User();
		user.setUsername(userId);
		return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/hello-world")
	public ResponseEntity<String> helloWorld() {
		final String message = "{\"message\":\"Hola mundo\"}";
		final ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.OK);
		return response;
	}

	@GetMapping("/peliculas")
	public ResponseEntity<List<String>> peliculas() {
		return new ResponseEntity<>(movieService.getPeliculas(), HttpStatus.OK);
	}

}
