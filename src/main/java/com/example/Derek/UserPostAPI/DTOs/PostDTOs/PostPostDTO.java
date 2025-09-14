package com.example.Derek.UserPostAPI.DTOs.PostDTOs;



public class PostPostDTO {
	
	private String title;
	private String content;
	private Long userAuthorId;
	
	public PostPostDTO () {}

	public PostPostDTO(String title, String content, Long userAuthorId) {
		this.title = title;
		this.content = content;
		this.userAuthorId = userAuthorId;
	}

	public String getTitle() { return title; }
	public String getContent() { return content; }
	public Long getUserAuthorId() { return userAuthorId; }
	
	
	
	
}
