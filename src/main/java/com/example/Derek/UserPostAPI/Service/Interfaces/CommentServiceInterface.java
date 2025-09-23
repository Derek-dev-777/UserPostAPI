package com.example.Derek.UserPostAPI.Service.Interfaces;

import java.util.List;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPostDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPutDTO;

public interface CommentServiceInterface {
	
	public CommentGetDTO findCommentById(Long id);
	public List<CommentGetDTO> findAllComments();
	public CommentGetDTO createComment(CommentPostDTO dto);
	public CommentGetDTO updateComment(CommentPutDTO dto, Long id);
	public void deleteCommentById(Long id);
}
