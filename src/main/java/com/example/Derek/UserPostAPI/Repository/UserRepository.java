package com.example.Derek.UserPostAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Derek.UserPostAPI.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
