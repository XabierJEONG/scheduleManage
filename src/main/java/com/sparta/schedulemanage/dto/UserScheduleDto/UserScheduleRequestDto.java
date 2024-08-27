package com.sparta.schedulemanage.dto.UserScheduleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserScheduleRequestDto {
    private Long userId;
    private Long scheduleId;
}
