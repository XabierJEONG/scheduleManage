package com.sparta.schedulemanage.dto.UserDto;

import com.sparta.schedulemanage.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createAt = user.getCreateAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
