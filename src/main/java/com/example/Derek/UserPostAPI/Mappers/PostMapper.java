package com.example.Derek.UserPostAPI.Mappers;

import java.util.stream.Collectors;

import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;

public class PostMapper {

	public static PostGetDTO convertEntityToDto(PostEntity entity){
		return new PostGetDTO(entity.getId(),entity.getTitle(),entity.getContent(),entity.getCreatedAt(), entity.getUserAuthor().getId(), entity.getComments().stream()
                .map(CommentMapper::convertEntityToDto)
                .collect(Collectors.toList()));
	}
	
	public static PostEntity convertDtoToEntity(PostPostDTO dto, UserEntity author) {
		return new PostEntity(dto.getTitle(),dto.getContent(),author);
	}
}
