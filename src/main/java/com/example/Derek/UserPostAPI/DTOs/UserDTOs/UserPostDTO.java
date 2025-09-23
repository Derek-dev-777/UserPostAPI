package com.example.Derek.UserPostAPI.DTOs.UserDTOs;

public class UserPostDTO {
	
	public String name;
	public String email;
	public String password;
	
	public UserPostDTO() {}

	public UserPostDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	
	
	
	
}
