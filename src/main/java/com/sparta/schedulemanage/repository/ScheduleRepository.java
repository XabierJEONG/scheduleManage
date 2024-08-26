package com.sparta.schedulemanage.repository;

import com.sparta.schedulemanage.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @EntityGraph(attributePaths = "comments")
    Page<Schedule> findAllByOrderByModifiedAtDesc (Pageable pageable);
}
