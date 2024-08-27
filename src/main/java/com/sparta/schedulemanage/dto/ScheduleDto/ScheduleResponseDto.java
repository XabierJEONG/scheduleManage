package com.sparta.schedulemanage.dto.ScheduleDto;

import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.entity.User;
import com.sparta.schedulemanage.entity.UserSchedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<UserInfo> users = new ArrayList<>();

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleContent = schedule.getScheduleContent();
        this.createAt = schedule.getCreateAt();
        this.modifiedAt = schedule.getModifiedAt();
        for (UserSchedule userSchedule : schedule.getUserSchedules()) {
            User user = userSchedule.getUser();
            this.users.add(new UserInfo(user));
        }
    }
    // 사용자 정보만 포함하는 내부 클래스
    @Getter
    @Setter
    public static class UserInfo {
        private Long userId;
        private String username;
        private String email;
        public UserInfo(User user) {
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
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
