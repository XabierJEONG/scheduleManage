package com.sparta.schedulemanage.repository;

import com.sparta.schedulemanage.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
