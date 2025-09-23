package com.example.Derek.UserPostAPI.Service.Interfaces;

import java.util.List;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPutDTO;

public interface UserServiceInterface {
	
	public UserGetDTO findUserById(Long id);
	public List<UserGetDTO> findAllUsers();
	public UserGetDTO createUser(UserPostDTO dto);
	public UserGetDTO updateUser(UserPutDTO dto, Long id);
	public void deleteUserById(Long id);
	public List<PostGetDTO> findAllPostsOfUserID(Long id);
	public List<CommentGetDTO> findAllCommentsOfUserID(Long id);
	
}
