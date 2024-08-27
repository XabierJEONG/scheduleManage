package com.sparta.schedulemanage.controller;

import com.sparta.schedulemanage.dto.CommentDto.CommentRequestDto;
import com.sparta.schedulemanage.dto.CommentDto.CommentResponseDto;
import com.sparta.schedulemanage.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    // 등록
    @PostMapping("/comment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.createComment(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // 단건 조회
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentResponseDto> findComment(@PathVariable Long commentId) {
        CommentResponseDto responseDto = commentService.readComment(commentId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 다건 조회
    @GetMapping("/comments")
    public ResponseEntity<List<CommentResponseDto>> findCommentList() {
        List<CommentResponseDto> responseDto = commentService.readCommentList();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 수정
    @PutMapping("/comment/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(commentId, requestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //삭제
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}