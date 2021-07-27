package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private List<User> users;
	
	public UserController() {
		this.users = new ArrayList<>();
		this.users.add(new User(1, "Sirish", "Brum", "skc@qa.com"));
	}
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return this.users;
		
	}
	
	@PostMapping
	public void createUser(@Valid @RequestBody User user) {
		this.users.add(user);	
		
	}
	
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable("id") int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	@GetMapping("/email")
	public User getUserByEmail(@RequestParam("email") String email) {
		for (User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		
		return null;
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		for(User u : users) {
			if(u.getId() == id) {
				u.setName(user.getName());
				u.setAddress(user.getAddress());
				u.setEmail(user.getEmail());
				
				return u;
			}
		}
		return null;
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if(u.getId() == id) {
				this.users.remove(u);
				break;
			}
		}
	}
}