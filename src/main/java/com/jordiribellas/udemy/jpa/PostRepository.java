package com.jordiribellas.udemy.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordiribellas.udemy.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
