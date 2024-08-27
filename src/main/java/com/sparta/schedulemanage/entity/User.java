package com.sparta.schedulemanage.entity;

import com.sparta.schedulemanage.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    public User (UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }

    public void update(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }
}
