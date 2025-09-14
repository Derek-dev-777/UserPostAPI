package com.example.Derek.UserPostAPI.Mappers;

import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.UserPostAPI.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.UserPostAPI.Entity.UserEntity;

public class UserMapper {
	
	public static UserGetDTO convertEntityToDto(UserEntity entity) {
		return new UserGetDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getCreatedAt());
	}
	
	public static UserEntity convertDtoToEntity(UserPostDTO dto) {
		return new UserEntity(dto.getName(), dto.getEmail(), dto.getPassword());
	}
	
}
