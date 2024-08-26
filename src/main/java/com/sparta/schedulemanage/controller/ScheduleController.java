package com.sparta.schedulemanage.controller;

import com.sparta.schedulemanage.dto.ScheduleRequestDto;
import com.sparta.schedulemanage.dto.ScheduleResponseDto;
import com.sparta.schedulemanage.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto findSchedule(@PathVariable Long id) {
        return scheduleService.readSchedule(id);
    }

    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedule/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}
