package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String header;
    private String username;
    private String contents;
    private String password;
}
