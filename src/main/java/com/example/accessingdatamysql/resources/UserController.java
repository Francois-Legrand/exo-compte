package com.example.accessingdatamysql.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.IDao.IDao;
import com.example.accessingdatamysql.domain.Adresse;
import com.example.accessingdatamysql.domain.User;

@RestController
@RequestMapping(path="/demo")

public class UserController {
	
	@Autowired
	private IDao<User> userRepository;
	
	//Get all users
	@GetMapping(path="/user")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	//Get User
	@GetMapping(path="/user/{id}")
	public @ResponseBody User one(@PathVariable Integer id) {
		    
		return userRepository.findById(id);
	}
	
	//Post user
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @ModelAttribute Adresse adresse) {
		
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setAdresse(adresse);
		userRepository.create(newUser);
		return "saved";
		
	}
	//Update user
	@PutMapping(path="/user/{id}/edit")
	public String userEdit(@PathVariable Integer id, @ModelAttribute User usr ,@ModelAttribute Adresse adresse) {
		
		User user = userRepository.findById(id);
		
		user.setEmail(usr.getEmail());
		user.setName(usr.getName());
		user.setAdresse(adresse);
		
		userRepository.create(user);
		return "user update";
		
	}
	
	@DeleteMapping(path="/user/{id}/delete")
	public @ResponseBody String deleteUser(@PathVariable Integer id) {
	    userRepository.deleteById(id);
	    return "utilisateur supprimer";
	}

	
}
