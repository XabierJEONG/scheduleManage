package com.sparta.schedulemanage.dto.CommentDto;

import com.sparta.schedulemanage.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long commentId;
    private String commentContent;
    private String commentUsername;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentContent = comment.getCommentContent();
        this.commentUsername = comment.getCommentUsername();
        this.createAt = comment.getCreateAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
