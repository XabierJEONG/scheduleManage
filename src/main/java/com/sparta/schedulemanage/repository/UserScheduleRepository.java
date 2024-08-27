package com.sparta.schedulemanage.repository;

import com.sparta.schedulemanage.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
    List<UserSchedule> findByUser_UserId(Long userId);
}