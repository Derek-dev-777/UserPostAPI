package com.example.Derek.UserPostAPI.Service.Interfaces;

import java.util.List;

import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPutDTO;

public interface PostServiceInterface {
	
	public PostGetDTO findPostById(Long id);
	public List<PostGetDTO> findAllPosts();
	public PostGetDTO createPost(PostPostDTO dto);
	public PostGetDTO updatePost(PostPutDTO dto, Long id);
	public void deletePostById(Long id);
	
}
