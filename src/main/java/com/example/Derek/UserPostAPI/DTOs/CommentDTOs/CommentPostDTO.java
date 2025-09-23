package com.example.Derek.UserPostAPI.DTOs.CommentDTOs;


public class CommentPostDTO {
	
	public String content;
	public Long author_id;
	public Long post_id;
	
	public CommentPostDTO() {}

	public CommentPostDTO(String content, Long author_id, Long post_id) {
		this.content = content;
		this.author_id = author_id;
		this.post_id = post_id;
	}

	public String getContent() { return content; }
	public Long getAuthor_id() { return author_id; }
	public Long getPost_id() { return post_id; }
	
	
}
