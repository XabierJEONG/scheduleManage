package com.sparta.schedulemanage.service;

import com.sparta.schedulemanage.dto.CommentDto.CommentRequestDto;
import com.sparta.schedulemanage.dto.CommentDto.CommentResponseDto;
import com.sparta.schedulemanage.entity.Comment;
import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.repository.CommentRepository;
import com.sparta.schedulemanage.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }
    // 등록
    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        // 찾기
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );
        // RequestDto -> Entity
        Comment comment = new Comment(schedule, requestDto);
        // DB 저장
        Comment saveComment = commentRepository.save(comment);
        // Entity -> ResponseDto
        return new CommentResponseDto(saveComment);
    }
    // 단건 조회
    public CommentResponseDto readComment(Long commentId) {
        Comment comment = findComment(commentId);
        return new CommentResponseDto(comment);
    }
    //다건 조회
    public List<CommentResponseDto> readCommentList() {
        return commentRepository.findAllByOrderByModifiedAtDesc().stream().map(CommentResponseDto::new).toList();
    }
    // 수정
    @Transactional
    public Long updateComment(Long commentId, CommentRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return commentId;
    }
    // 삭제
    public Long deleteComment(Long commentId) {
        // 해당 메모가 DB에 존재하는지 확인
        Comment comment = findComment(commentId);
        commentRepository.delete(comment);
        return commentId;

    }
    // 조회용 메서드
    public Comment findComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }
}
