package com.sparta.schedulemanage.dto.UserScheduleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserScheduleResponseDto {
    private Long id;
    private Long userId;
    private Long scheduleId;

    public UserScheduleResponseDto(Long id, Long userId, Long scheduleId) {
        this.id = id;
        this.userId = userId;
        this.scheduleId = scheduleId;
    }
}
