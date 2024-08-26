package com.sparta.schedulemanage.service;

import com.sparta.schedulemanage.dto.ScheduleRequestDto;
import com.sparta.schedulemanage.dto.ScheduleResponseDto;
import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    // 등록
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        return new ScheduleResponseDto(saveSchedule);
    }
    // 조회
    public ScheduleResponseDto readSchedule(Long scheduleId) {
        Schedule schedule = findSchedule(scheduleId);
        return new ScheduleResponseDto(schedule);
    }

    // 수정
    @Transactional
    public Long updateSchedule(Long scheduleId, ScheduleRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
        schedule.update(requestDto);
        return scheduleId;
    }

    public Long deleteSchedule(Long scheduleId) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(scheduleId);
        scheduleRepository.delete(schedule);
        return scheduleId;

    }

    public Schedule findSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}
