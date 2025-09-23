package com.example.Derek.UserPostAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Derek.UserPostAPI.Entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
