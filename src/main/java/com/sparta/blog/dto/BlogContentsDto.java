package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;

@Getter
public class BlogContentsDto {
    private String contents;

    public BlogContentsDto(Blog blog) {
        this.contents = blog.getContents();
    }
}
