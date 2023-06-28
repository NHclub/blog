package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class BlogRequestUpdateDto {
    private String header;
    private String username;
    private String contents;
}
