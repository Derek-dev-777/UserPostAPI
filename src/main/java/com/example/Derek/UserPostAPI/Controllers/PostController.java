package com.example.Derek.UserPostAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPutDTO;
import com.example.Derek.UserPostAPI.Service.Impl.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	public PostController() {}
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostGetDTO> findPostById(@PathVariable Long id) {
		PostGetDTO postToReturn = postService.findPostById(id);
		return ResponseEntity.ok(postToReturn);
	}
	
	@GetMapping
	public ResponseEntity<List<PostGetDTO>> findAllPosts(){
		List<PostGetDTO> postsToReturn = postService.findAllPosts();
		return ResponseEntity.ok(postsToReturn);
	}
	
	@PostMapping
	public ResponseEntity<PostGetDTO> createPost(@RequestBody PostPostDTO dto){
		PostGetDTO postCreated = postService.createPost(dto);
		return ResponseEntity.status(201).body(postCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostGetDTO> updatePost(@RequestBody PostPutDTO dto,@PathVariable Long id){
		PostGetDTO postUpdated = postService.updatePost(dto, id);
		return ResponseEntity.ok(postUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePostById(@PathVariable Long id){
		postService.deletePostById(id);
		return ResponseEntity.noContent().build();
	}
}
