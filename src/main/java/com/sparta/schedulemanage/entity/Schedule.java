package com.sparta.schedulemanage.entity;

import com.sparta.schedulemanage.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "scheduleTitle", nullable = false)
    private String scheduleTitle;

    @Column(name = "scheduleContent", nullable = false)
    private String scheduleContent;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.scheduleTitle = requestDto.getScheduleTitle();
        this.scheduleContent = requestDto.getScheduleContent();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.scheduleTitle = requestDto.getScheduleTitle();
        this.scheduleContent = requestDto.getScheduleContent();
    }
}
