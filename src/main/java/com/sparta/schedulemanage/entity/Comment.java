package com.sparta.schedulemanage.entity;

import com.sparta.schedulemanage.dto.CommentDto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "commentContent", nullable = false)
    private String commentContent;

    @Column(name = "commentUsername", nullable = false)
    private String commentUsername;

    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule schedule;
    public Comment(Schedule schedule, CommentRequestDto requestDto) {
        this.schedule = schedule;
        this.commentContent = requestDto.getCommentContent();
        this.commentUsername = requestDto.getCommentUsername();
    }
    public void update(CommentRequestDto requestDto) {
        this.commentContent = requestDto.getCommentContent();
        this.commentUsername = requestDto.getCommentUsername();
    }
}
