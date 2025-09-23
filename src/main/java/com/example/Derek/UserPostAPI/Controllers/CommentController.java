package com.example.Derek.UserPostAPI.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPostDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPutDTO;
import com.example.Derek.UserPostAPI.Service.Impl.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	public CommentService commentService;
	
	public CommentController(CommentService service) {
		this.commentService = service;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CommentGetDTO> findCommentById(@PathVariable Long id){
		CommentGetDTO commentFound = commentService.findCommentById(id);
		return ResponseEntity.ok(commentFound);
	}
	
	@GetMapping
	public ResponseEntity<List<CommentGetDTO>> findAllComments(){
		List<CommentGetDTO> listOfComments = commentService.findAllComments();
		return ResponseEntity.ok(listOfComments);
	}
	
	@PostMapping
	public ResponseEntity<CommentGetDTO> createComment(@RequestBody CommentPostDTO dto){
		CommentGetDTO commentCreated = commentService.createComment(dto);
		return ResponseEntity.status(201).body(commentCreated);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CommentGetDTO> updateComment(@RequestBody CommentPutDTO dto, @PathVariable Long id){
		CommentGetDTO commentUpdated = commentService.updateComment(dto, id);
		return ResponseEntity.ok(commentUpdated);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id){
		commentService.deleteCommentById(id);
		return ResponseEntity.noContent().build();
	}
}
