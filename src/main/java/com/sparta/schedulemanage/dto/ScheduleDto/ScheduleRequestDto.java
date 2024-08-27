package com.sparta.schedulemanage.dto.ScheduleDto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long userId;
    private String scheduleTitle;
    private String scheduleContent;
}
