package br.com.unicuritiba.ProjetoA3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.unicuritiba.ProjetoA3.Models.User;
import br.com.unicuritiba.ProjetoA3.Services.UserService;


	@RestController
	public class UserController {

		@Autowired
		UserService service;
		
		@GetMapping("/users")
		public ResponseEntity<List<User>> getUsers(){
			return ResponseEntity.ok(service.getAllUser());	
		}

		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUser(@PathVariable long id){
			return ResponseEntity.ok(service.getUserById(id));	
		}
		
		@PostMapping("/users")
		public ResponseEntity<User> saveUser(
				@RequestBody User user){
			return ResponseEntity.ok(service.saveUser(user));
		}
		
		@DeleteMapping("/users/{id}")
		public void removeUser(@PathVariable long id) {
			 service.removeUser(id);
		}
		
		@PutMapping("/users/{id}")
		public ResponseEntity<User> updateUser(@PathVariable long id,
				@RequestBody User user) {
			return ResponseEntity.ok(service.updateUser(id, user));
		}
	}


