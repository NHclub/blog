package com.sparta.blog.service;

import com.sparta.blog.dto.*;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogResponseDto> getBlogs() {
        return blogRepository.findAllByOrderByCreatedAtDesc().stream().map(BlogResponseDto::new).toList();
    }

    public BlogContentsDto createBlog(BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);

        Blog saveblog = blogRepository.save(blog);

        BlogContentsDto blogContentsDto = new BlogContentsDto(blog);

        return blogContentsDto;
    }

    public List<BlogFindContentsDto> getBlogsByKeyword(String keyword) {
        return blogRepository.findAllByContentsContains(keyword).stream().map(BlogFindContentsDto::new).toList();
    }

    @Transactional
    public BlogContentsDto updateBlog(String password, BlogRequestUpdateDto blogRequestUpdateDto) {

        Blog blog = findBlog(password);

        blog.update(blogRequestUpdateDto);

        BlogContentsDto blogContentsDto = new BlogContentsDto(new Blog(blogRequestUpdateDto));

        return blogContentsDto;
    }



    public String deleteBlogs(String password) {
        Blog blog = findBlog(password);

        blogRepository.delete(blog);

        return "삭제 성공";
    }

    private Blog findBlog(String password) {
        if(blogRepository.findByPassword(password) != null){
            return blogRepository.findByPassword(password);
        }else {
            throw new IllegalArgumentException("패스워드가 존재하지 않습니다.");
        }
    }
}
