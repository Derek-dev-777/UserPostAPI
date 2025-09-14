package com.example.Derek.UserPostAPI.DTOs.UserDTOs;

import java.time.LocalDateTime;


public class UserGetDTO {
	
	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	
	
	public UserGetDTO() {}

	public UserGetDTO(Long id, String name, String email, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public LocalDateTime getCreatedAt() { return createdAt; }

	
	
}
