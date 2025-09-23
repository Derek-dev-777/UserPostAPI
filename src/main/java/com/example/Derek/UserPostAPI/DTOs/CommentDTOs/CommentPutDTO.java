package com.example.Derek.UserPostAPI.DTOs.CommentDTOs;

public class CommentPutDTO {
	
	public String content;
	
	public CommentPutDTO () {}

	public CommentPutDTO(String content) {
		this.content = content;
	}

	public String getContent() { return content; }
	
	
	
}
