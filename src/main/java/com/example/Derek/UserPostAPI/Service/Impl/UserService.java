package com.example.Derek.UserPostAPI.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPutDTO;
import com.example.Derek.UserPostAPI.Entity.CommentEntity;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;
import com.example.Derek.UserPostAPI.Mappers.CommentMapper;
import com.example.Derek.UserPostAPI.Mappers.PostMapper;
import com.example.Derek.UserPostAPI.Mappers.UserMapper;
import com.example.Derek.UserPostAPI.Repository.UserRepository;
import com.example.Derek.UserPostAPI.Service.Interfaces.UserServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {}
	
	public UserService(UserRepository repository) {
		this.userRepository = repository;
	}
	
	@Transactional
	@Override
	public UserGetDTO findUserById(Long id) {
		UserEntity userFound = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
		UserGetDTO userToReturn = UserMapper.convertEntityToDto(userFound);
		return userToReturn;
	}
	
	@Transactional
	@Override
	public List<UserGetDTO> findAllUsers() {
		List<UserEntity> listOfUserEntity = userRepository.findAll();
		List<UserGetDTO> listOfUserToReturn = new ArrayList<UserGetDTO>();
		
		for(UserEntity user : listOfUserEntity) {
			UserGetDTO userConverted = UserMapper.convertEntityToDto(user);
			listOfUserToReturn.add(userConverted);
		}
		return listOfUserToReturn;
	}
	
	@Transactional
	@Override
	public List<PostGetDTO> findAllPostsOfUserID(Long id) {
		UserEntity userToGetPosts = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user found"));
		List<PostEntity> listOfPosts = userToGetPosts.getPosts();
		List<PostGetDTO> listToReturn = new ArrayList<>();
		
		for(PostEntity posts : listOfPosts) {
			listToReturn.add(PostMapper.convertEntityToDto(posts));
		}
		return listToReturn;
	}
	
	@Transactional
	@Override
	public List<CommentGetDTO> findAllCommentsOfUserID(Long id) {
		UserEntity userToGetComments = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user found"));
		List<CommentEntity> listOfComments = userToGetComments.getComments();
		List<CommentGetDTO> listToReturn = new ArrayList<>();
		
		for(CommentEntity comment : listOfComments) {
			listToReturn.add(CommentMapper.convertEntityToDto(comment));
		}
		return listToReturn;
	}
	
	@Override
	public UserGetDTO createUser(UserPostDTO dto) {
		UserEntity userSavedAndCreated = userRepository.save(new UserEntity(
				dto.getName(), dto.getEmail(), dto.getPassword()));
		
		UserGetDTO userToReturn = UserMapper.convertEntityToDto(userSavedAndCreated);
		return userToReturn;
	}
	
	@Override
	public UserGetDTO updateUser(UserPutDTO dto, Long id) {
		UserEntity userFound = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
		
		userFound.setName(dto.getName());
		userFound.setEmail(dto.getEmail());
		userFound.setPassword(dto.getPassword());
		
		UserEntity userUpdatedAndSaved = userRepository.save(userFound);
		UserGetDTO userToReturn = UserMapper.convertEntityToDto(userUpdatedAndSaved);
		return userToReturn;
				
	}

	@Override
	public void deleteUserById(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
		
	}


}
