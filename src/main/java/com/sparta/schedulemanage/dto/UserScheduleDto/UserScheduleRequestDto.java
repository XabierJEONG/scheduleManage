package com.sparta.schedulemanage.dto.UserScheduleDto;

import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserScheduleRequestDto {
    private Long userId;
    private Long scheduleId;

    public UserScheduleRequestDto(Long userId, Long scheduleId) {
        this.userId = userId;
        this.scheduleId = scheduleId;
    }
}
