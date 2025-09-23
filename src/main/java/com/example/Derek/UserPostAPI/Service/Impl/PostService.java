 package com.example.Derek.UserPostAPI.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPutDTO;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;
import com.example.Derek.UserPostAPI.Mappers.PostMapper;
import com.example.Derek.UserPostAPI.Repository.PostRepository;
import com.example.Derek.UserPostAPI.Repository.UserRepository;
import com.example.Derek.UserPostAPI.Service.Interfaces.PostServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class PostService implements PostServiceInterface {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public PostService() {}
	
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	@Override
	public PostGetDTO findPostById(Long id) {
		PostEntity postFound = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
		PostGetDTO postToReturn = PostMapper.convertEntityToDto(postFound);
		return postToReturn;
	}
	
	@Transactional
	@Override
	public List<PostGetDTO> findAllPosts() {
		List<PostEntity> listOfPostEntity = postRepository.findAll();
		List<PostGetDTO> listToReturn = new ArrayList<PostGetDTO>();
		
		for(PostEntity post : listOfPostEntity) {
			PostGetDTO postConverted = PostMapper.convertEntityToDto(post);
			listToReturn.add(postConverted);
		}
		
		return listToReturn;
	}

	@Override
	public PostGetDTO createPost(PostPostDTO dto) {
		UserEntity user = userRepository.findById(dto.getUserAuthorId()).orElseThrow(() -> new NoSuchElementException("User not found"));
		PostEntity postCreated = new PostEntity(dto.getTitle(),dto.getContent(), user);
		PostEntity postCreatedAndSaved = postRepository.save(postCreated);
		PostGetDTO postToReturn = PostMapper.convertEntityToDto(postCreatedAndSaved);
		return postToReturn;
	}

	@Override
	public PostGetDTO updatePost(PostPutDTO dto, Long id) {
		PostEntity postFound = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
		
		postFound.setTitle(dto.getTitle());
		postFound.setContent(dto.getContent());
		
		PostEntity postUpdatedAndSaved = postRepository.save(postFound);
		PostGetDTO postToReturn = PostMapper.convertEntityToDto(postUpdatedAndSaved);
		return postToReturn;
	}

	@Override
	public void deletePostById(Long id) {
		if(postRepository.existsById(id)) {
			postRepository.deleteById(id);
		}
		
	}

}
