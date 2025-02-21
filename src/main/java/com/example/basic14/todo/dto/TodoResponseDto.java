package com.example.basic14.todo.dto;

import lombok.Getter;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String content;


    public TodoResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
