package com.example.Derek.UserPostAPI.Controllers;

import java.util.List;

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

import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPutDTO;
import com.example.Derek.UserPostAPI.Service.Impl.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {}
	
	public UserController(UserService service) {
		this.userService = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserGetDTO> findUserById(@PathVariable Long id) {
		UserGetDTO userToReturn = userService.findUserById(id);
		return ResponseEntity.ok(userToReturn);
	}
	
	@GetMapping
	public ResponseEntity<List<UserGetDTO>> findAllUsers(){
		List<UserGetDTO> listToReturn = userService.findAllUsers();
		return ResponseEntity.ok(listToReturn);
	}
	
	@PostMapping
	public ResponseEntity<UserGetDTO> createUser(@RequestBody UserPostDTO dto){
		UserGetDTO userToReturn = userService.createUser(dto);
		return ResponseEntity.status(201).body(userToReturn);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserGetDTO> updateUser(@RequestBody UserPutDTO dto, @PathVariable Long id){
		UserGetDTO userToReturn = userService.updateUser(dto, id);
		return ResponseEntity.ok(userToReturn);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	
}
