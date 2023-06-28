package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class BlogFindContentsDto {
    private String header;
    private String username;
    private LocalDateTime modified;
    private String contents;

    public BlogFindContentsDto(Blog blog) {
        this.header = blog.getHeader();
        this.username = blog.getUsername();
        this.modified = blog.getModifiedAt();
        this.contents = blog.getContents();
    }
}