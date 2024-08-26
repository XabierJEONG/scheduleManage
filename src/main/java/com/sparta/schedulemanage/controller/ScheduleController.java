package com.sparta.schedulemanage.controller;

import com.sparta.schedulemanage.dto.ScheduleRequestDto;
import com.sparta.schedulemanage.dto.ScheduleResponseDto;
import com.sparta.schedulemanage.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    // 등록
    @PostMapping("/schedule")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // 단건 조회
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long scheduleId) {
        ScheduleResponseDto responseDto = scheduleService.readSchedule(scheduleId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 페이지 조회
    @GetMapping("/schedules")
    public Page<ScheduleResponseDto> findScheduleList(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return scheduleService.getSchedules(page,size);
    }
    // 수정
    @PutMapping("/schedule/{scheduleId}")
    public ResponseEntity<Void> updateSchedule(@PathVariable Long scheduleId,
                                               @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.updateSchedule(scheduleId, requestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //삭제
    @DeleteMapping("/schedule/{scheduleId}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
