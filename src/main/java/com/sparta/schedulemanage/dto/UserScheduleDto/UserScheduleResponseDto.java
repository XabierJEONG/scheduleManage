package com.sparta.schedulemanage.dto.UserScheduleDto;

import com.sparta.schedulemanage.entity.UserSchedule;
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

    public UserScheduleResponseDto(UserSchedule userSchedule) {
        this.id = userSchedule.getId();
        this.scheduleId = userSchedule.getSchedule().getScheduleId();
        this.userId = userSchedule.getUser().getUserId();
    }
}
