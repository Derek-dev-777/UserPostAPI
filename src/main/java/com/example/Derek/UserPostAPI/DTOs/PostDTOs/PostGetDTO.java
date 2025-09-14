package com.example.Derek.UserPostAPI.DTOs.PostDTOs;

import java.time.LocalDateTime;

public class PostGetDTO {
	
	private Long id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Long authorId;
	
	public PostGetDTO () {}
	
	public PostGetDTO(Long id, String title, String content, LocalDateTime createdAt, Long authorId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.authorId = authorId;
	}

	public Long getId() { return id; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public Long getAuthorId() { return authorId; }
}
