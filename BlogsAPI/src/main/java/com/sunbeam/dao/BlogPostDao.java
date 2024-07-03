package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.BlogPost;

public interface BlogPostDao extends JpaRepository<BlogPost, Long> {

	Optional<BlogPost> findByTitle(String title);

}
