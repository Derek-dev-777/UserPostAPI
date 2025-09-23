package com.example.Derek.UserPostAPI.Mappers;

import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentGetDTO;
import com.example.Derek.UserPostAPI.DTOs.CommentDTOs.CommentPostDTO;
import com.example.Derek.UserPostAPI.Entity.CommentEntity;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;

public class CommentMapper {
	
	public static CommentGetDTO convertEntityToDto(CommentEntity entity){
		return new CommentGetDTO(entity.getId(),entity.getContent(),entity.getCreatedAt(),entity.getAuthor().getId(),entity.getPost().getId());
	}
	
	public static CommentEntity convertDtoToEntity(CommentPostDTO dto, UserEntity author, PostEntity post) {
		return new CommentEntity(dto.getContent(), author, post);
	}
	
}
