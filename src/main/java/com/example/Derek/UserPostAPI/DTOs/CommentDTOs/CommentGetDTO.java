package com.example.Derek.UserPostAPI.DTOs.CommentDTOs;

import java.time.LocalDateTime;

public class CommentGetDTO {
	
	public Long id;
	public String content;
	public LocalDateTime createdAt;
	public Long author_id;
	public Long post_id;
	
	public CommentGetDTO() {}

	public CommentGetDTO(Long id, String content, LocalDateTime createdAt, Long author_id, Long post_id) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.author_id = author_id;
		this.post_id = post_id;
	}

	public Long getId() { return id; }
	public String getContent() { return content; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public Long getAuthor_id() { return author_id; }
	public Long getPost_id() { return post_id; }
	
	
	
	
}
