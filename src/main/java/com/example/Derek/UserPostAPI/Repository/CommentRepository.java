package com.example.Derek.UserPostAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Derek.UserPostAPI.Entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
