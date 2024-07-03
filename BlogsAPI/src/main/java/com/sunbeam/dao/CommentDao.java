package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

	Optional<List<Comment>> findAllByCommenterId(Long userId);

}
