package com.example.Derek.UserPostAPI.Mappers;

import java.util.stream.Collectors;

import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.UserPostAPI.Entity.UserEntity;

public class UserMapper {
	
	 public static UserGetDTO convertEntityToDto(UserEntity entity) {
	        return new UserGetDTO(
	                entity.getId(),
	                entity.getName(),
	                entity.getEmail(),
	                entity.getCreatedAt(),
	                entity.getPosts().stream()
	                      .map(PostMapper::convertEntityToDto)
	                      .collect(Collectors.toList()),
	                entity.getComments().stream()
	                      .map(CommentMapper::convertEntityToDto)
	                      .collect(Collectors.toList())
	        );
	        		
	    }
	
	public static UserEntity convertDtoToEntity(UserPostDTO dto) {
		return new UserEntity(dto.getName(), dto.getEmail(), dto.getPassword());
	}
	
}
