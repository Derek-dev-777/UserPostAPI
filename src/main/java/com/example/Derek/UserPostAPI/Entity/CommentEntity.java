package com.example.Derek.UserPostAPI.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_comments")
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(nullable = false, unique = true)
	public String content;
	
	@Column(nullable = false, updatable = false)
	public LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	public UserEntity author;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	public PostEntity post;
	
	public CommentEntity() {}

	
	
	public CommentEntity(String content, UserEntity author, PostEntity post) {
		this.content = content;
		this.author = author;
		this.post = post;
	}

	public String getContent() { return content; }
	public Long getId() { return id; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public UserEntity getAuthor() { return author; }
	public PostEntity getPost() { return post; }

	public void setContent(String content) { this.content = content; }
	public void setAuthor(UserEntity author) { this.author = author; }
	public void setPost(PostEntity post) { this.post = post; }
	
	
	
	
	
}
