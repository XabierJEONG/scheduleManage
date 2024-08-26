package com.sparta.schedulemanage.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long scheduleId;
    private String commentContent;
    private String commentUsername;
}
