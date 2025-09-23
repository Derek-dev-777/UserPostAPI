package com.example.Derek.UserPostAPI.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_posts")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userAuthor;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
	
	public PostEntity() {}

	public PostEntity(String title, String content,UserEntity userAuthor) {
		this.title = title;
		this.content = content;
		this.userAuthor = userAuthor;
	}

	public Long getId() { return id; }
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public UserEntity getUserAuthor() { return userAuthor; }
	public List<CommentEntity> getComments() { return comments; }

	public void setTitle(String title) { this.title = title; }
	public void setContent(String content) { this.content = content; }

	
	
}
