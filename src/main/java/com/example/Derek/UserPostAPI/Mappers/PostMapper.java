package com.example.Derek.UserPostAPI.Mappers;

import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.UserPostAPI.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.UserPostAPI.Entity.PostEntity;
import com.example.Derek.UserPostAPI.Entity.UserEntity;

public class PostMapper {

	public static PostGetDTO convertEntityToDto(PostEntity entity){
		return new PostGetDTO(entity.getId(),entity.getTitle(),entity.getContent(),entity.getCreatedAt(), entity.getUserAuthor().getId());
	}
	
	public static PostEntity convertDtoToEntity(PostPostDTO dto, UserEntity author) {
		return new PostEntity(dto.getTitle(),dto.getContent(),author);
	}
}
