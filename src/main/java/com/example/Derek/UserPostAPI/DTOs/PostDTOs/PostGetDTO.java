package com.example.Derek.UserPostAPI.DTOs.PostDTOs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;

public class PostGetDTO {
	
	private Long id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Long authorId;
	private List<CommentGetDTO> comments;
	
	public PostGetDTO () {}
	
	public PostGetDTO(Long id, String title, String content, LocalDateTime createdAt, Long authorId, List<CommentGetDTO> comments) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.authorId = authorId;
		this.comments = comments;
	}

	public Long getId() { return id; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public Long getAuthorId() { return authorId; }
	public List<CommentGetDTO> getComments() { return comments; }
}
