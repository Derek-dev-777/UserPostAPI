package com.example.Derek.UserPostAPI.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	
	public UserEntity() {}
	
	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() { return id ; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public LocalDateTime getCreatedAt() { return createdAt; }


	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }

	
	
	
}
