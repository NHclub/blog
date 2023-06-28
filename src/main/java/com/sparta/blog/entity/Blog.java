package com.sparta.blog.entity;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.dto.BlogRequestUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "blog")
@NoArgsConstructor
public class Blog extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", length = 65535 , nullable = false)
    private String contents;
    @Column(name = "password", nullable = false )
    private String password;
    @Column(name = "header", nullable = false)
    private String header;

    public Blog(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.header = requestDto.getHeader();
        this.password = requestDto.getPassword();
    }
    public Blog(BlogRequestUpdateDto blogRequestUpdateDto) {
        this.username = blogRequestUpdateDto.getUsername();
        this.contents = blogRequestUpdateDto.getContents();
        this.header = blogRequestUpdateDto.getHeader();
    }

    public void update(BlogRequestUpdateDto blogRequestUpdateDto) {
        this.username = blogRequestUpdateDto.getUsername();
        this.contents = blogRequestUpdateDto.getContents();
        this.header = blogRequestUpdateDto.getHeader();
    }

}
