package net.fishinapi.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import net.fishinapi.springboot.exception.ResourceNotFoundException;
import net.fishinapi.springboot.model.User;
import net.fishinapi.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	

	@Autowired
	private UserRepository userRepository;

	//get spot
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	// get spot by id	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getSpotById(@PathVariable(value="user_id") Long userId)
	throws ResourceNotFoundException{
		User user = userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de user trouvé à cet id :: "+userId));
				return ResponseEntity.ok().body(user);
	}
		
	
	//@RequestMapping(value = "/users",method = RequestMethod.POST,produces = "application/json")
	@PostMapping ("/users")
	public User createUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
		
	}
	//update
	@PutMapping("/users/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="user_id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException{
		
		User user = userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de user trouvé à cet id :: "+userId));
		user.setNom(userDetails.getNom());
		user.setPassword(userDetails.getPassword());	
		
		return ResponseEntity.ok(this.userRepository.save(user));
	}
	//delete
	@DeleteMapping("/users/{user_id}")
	public Map<String,Boolean> deleteSpot(@PathVariable(value="user_id") Long userId) throws ResourceNotFoundException{
		User user = userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de user trouvé à cet id :: "+userId));
		this.userRepository.delete(user);
		
		 Map<String,Boolean> response =new HashMap<>();
		 response.put("Supprimé", Boolean.TRUE);
		 
		 return response;
	}
}

