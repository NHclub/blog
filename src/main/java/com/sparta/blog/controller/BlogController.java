package com.sparta.blog.controller;

import com.sparta.blog.dto.*;
import com.sparta.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs") // 전체 게시글 목록 조회 API
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping("/blogs") // 게시글 작성 API
    public BlogContentsDto createBlog(@RequestBody BlogRequestDto requestDto) {
        return blogService.createBlog(requestDto);
    }

    @GetMapping("/blogs/contents") // 선택한 게시글 조회 API
    public List<BlogFindContentsDto> getBlogsByKeyword(@RequestParam String keyword){
        return blogService.getBlogsByKeyword(keyword);
    }

    @PutMapping("/blogs/{password}") // 선택한 게시글 수정 API
    public BlogContentsDto updateBlog(@PathVariable String password, @RequestBody BlogRequestUpdateDto blogRequestUpdateDto) {
        return blogService.updateBlog(password, blogRequestUpdateDto);
    }

    @DeleteMapping("/blogs/{password}") // 선택한 게시글 삭제 API
    public String deleteBlog(@PathVariable String password) {
        return blogService.deleteBlogs(password);
    }




}
