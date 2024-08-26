package com.sparta.schedulemanage.dto;

import com.sparta.schedulemanage.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String scheduleTitle;
    private String scheduleContent;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleContent = schedule.getScheduleContent();
        this.createAt = schedule.getCreateAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
