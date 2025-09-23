package com.example.Derek.UserPostAPI.DTOs.UserDTOs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;


public class UserGetDTO {
	
	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private List<PostGetDTO> posts;
	private List<CommentGetDTO> comments;
	
	
	public UserGetDTO() {}

	public UserGetDTO(Long id, String name, String email, LocalDateTime createdAt, List<PostGetDTO> posts, List<CommentGetDTO> comments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.posts = posts;
		this.comments = comments;	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public List<PostGetDTO> getPosts(){ return posts; }
	public List<CommentGetDTO> getComments(){ return comments; }
	
	
}
