package com.sparta.schedulemanage.dto.ScheduleDto;

import com.sparta.schedulemanage.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ScheduleResponseDto {
    private Long scheduleId;
    private String scheduleTitle;
    private String scheduleContent;
    private Long commentCount;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private String userId;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleContent = schedule.getScheduleContent();
        this.createAt = schedule.getCreateAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
    public ScheduleResponseDto(Long scheduleId,
                               String scheduleTitle,
                               String scheduleContent,
                               Long commentCount,
                               LocalDateTime createAt,
                               LocalDateTime modifiedAt) {
        this.scheduleId = scheduleId;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
        this.commentCount = commentCount;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
