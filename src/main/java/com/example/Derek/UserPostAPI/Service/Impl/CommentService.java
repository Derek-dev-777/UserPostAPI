package com.example.Derek.UserPostAPI.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPostDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPutDTO;
import com.example.Derek.UserPostAPI.Entity.CommentEntity;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;
import com.example.Derek.UserPostAPI.Mappers.CommentMapper;
import com.example.Derek.UserPostAPI.Repository.CommentRepository;
import com.example.Derek.UserPostAPI.Repository.PostRepository;
import com.example.Derek.UserPostAPI.Repository.UserRepository;
import com.example.Derek.UserPostAPI.Service.Interfaces.CommentServiceInterface;

@Service
public class CommentService implements CommentServiceInterface {
	
	public final CommentRepository commentRepository;
	public final UserRepository userRepository;
	public final PostRepository postRepository;
	
	public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public CommentGetDTO findCommentById(Long id) {
		CommentEntity commentFound = commentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No commentFound"));
		CommentGetDTO commentToReturn = CommentMapper.convertEntityToDto(commentFound);
		return commentToReturn;
	}

	@Override
	public List<CommentGetDTO> findAllComments() {
		List<CommentEntity> listOfCommentEntity = commentRepository.findAll();
		List<CommentGetDTO> listToReturn = new ArrayList<CommentGetDTO>();
		
		for(CommentEntity comment : listOfCommentEntity) {
			listToReturn.add(CommentMapper.convertEntityToDto(comment));
		}
		return listToReturn;
	}

	@Override
	public CommentGetDTO createComment(CommentPostDTO dto) {
		UserEntity author = userRepository.findById(dto.getAuthor_id()).orElseThrow(() -> new NoSuchElementException("No user found"));
		PostEntity post = postRepository.findById(dto.getPost_id()).orElseThrow(() -> new NoSuchElementException("No post found"));
		CommentEntity commentEntity = new CommentEntity(dto.getContent(), author, post);
		
		commentRepository.save(commentEntity);
		
		CommentGetDTO commentToReturn = CommentMapper.convertEntityToDto(commentEntity);
		
		return commentToReturn;
	}

	@Override
	public CommentGetDTO updateComment(CommentPutDTO dto, Long id) {
		CommentEntity commentToUpdate = commentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No comment found"));
		commentToUpdate.setContent(dto.getContent());
		commentRepository.save(commentToUpdate);
		
		CommentGetDTO commentToReturn = CommentMapper.convertEntityToDto(commentToUpdate);
		return commentToReturn;
	}

	@Override
	public void deleteCommentById(Long id) {
		commentRepository.deleteById(id);
	}

}
