package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class BlogResponseDto {
    private String header;
    private String username;
    private LocalDateTime createAt; // 객체가 처음 생성된 시각 저장
    private String contents;

    public BlogResponseDto(Blog blog) {
        this.header = blog.getHeader();
        this.username = blog.getUsername();
        this.createAt = blog.getCreatedAt();
        this.contents = blog.getContents();
    }
}
