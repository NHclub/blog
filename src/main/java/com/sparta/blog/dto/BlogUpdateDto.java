package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;

@Getter
public class BlogUpdateDto {
    private String header;
    private String username;
    private String contents;

    public BlogUpdateDto(Blog blog) {
        this.header = blog.getHeader();
        this.username = blog.getUsername();
        this.contents = blog.getContents();
    }
}
