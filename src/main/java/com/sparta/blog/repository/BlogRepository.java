package com.sparta.blog.repository;

import com.sparta.blog.dto.BlogUpdateDto;
import com.sparta.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByOrderByCreatedAtDesc();

    Blog findByPassword(String password);


    List<Blog> findAllByContentsContains(String keyword);
}
