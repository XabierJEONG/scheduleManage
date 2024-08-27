package com.sparta.schedulemanage.controller;

import com.sparta.schedulemanage.dto.UserScheduleDto.UserScheduleRequestDto;
import com.sparta.schedulemanage.dto.UserScheduleDto.UserScheduleResponseDto;
import com.sparta.schedulemanage.service.UserScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserScheduleController {
    private final UserScheduleService userScheduleService;
    public UserScheduleController(UserScheduleService userScheduleService) {
        this.userScheduleService = userScheduleService;
    }
    // 일정 내 추가 유저 등록
    @PostMapping("/UserSchedule")
    public ResponseEntity<UserScheduleResponseDto> createUserSchedule(@RequestBody UserScheduleRequestDto requestDto) {
        UserScheduleResponseDto responseDto = userScheduleService.createUserSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // 조회
    @GetMapping("/UserSchedule/schedule/{scheduleId}")
    public ResponseEntity<List<UserScheduleResponseDto>> findUserScheduleByUserId(@PathVariable Long scheduleId) {
        List<UserScheduleResponseDto> responseDto = userScheduleService.getUserSchedulesByScheduleId(scheduleId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 삭제
    @DeleteMapping("/UserSchedule/{id}")
    public ResponseEntity<Void> deleteUserSchedule(@PathVariable Long id) {
        userScheduleService.deleteUserSchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
