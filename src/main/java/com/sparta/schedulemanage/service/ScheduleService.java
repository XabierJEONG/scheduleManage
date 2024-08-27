package com.sparta.schedulemanage.service;

import com.sparta.schedulemanage.dto.ScheduleDto.ScheduleRequestDto;
import com.sparta.schedulemanage.dto.ScheduleDto.ScheduleResponseDto;
import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.entity.User;
import com.sparta.schedulemanage.entity.UserSchedule;
import com.sparta.schedulemanage.repository.ScheduleRepository;
import com.sparta.schedulemanage.repository.UserRepository;
import com.sparta.schedulemanage.repository.UserScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final UserScheduleRepository userScheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository, UserScheduleRepository userScheduleRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.userScheduleRepository = userScheduleRepository;
    }
    // 등록
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() ->
                new IllegalArgumentException("해당하는 유저가 없습니다."));

        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        UserSchedule userSchedule = new UserSchedule(user, saveSchedule);
        userScheduleRepository.save(userSchedule);

        // Entity -> ResponseDto
        return new ScheduleResponseDto(saveSchedule);
    }
    // 조회
    public ScheduleResponseDto readSchedule(Long scheduleId) {
        Schedule schedule = findSchedule(scheduleId);
        return new ScheduleResponseDto(schedule);
    }
    // 페이지 조회
    @Transactional
    public Page<ScheduleResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Schedule> schedules = scheduleRepository.findAllByOrderByModifiedAtDesc(pageable);

        return schedules.map(schedule -> {
            Long commentCount = schedule.getComments().isEmpty() ? null : (long) schedule.getComments().size();
            return new ScheduleResponseDto(
                    schedule.getScheduleId(),
                    schedule.getScheduleTitle(),
                    schedule.getScheduleContent(),
                    commentCount,
                    schedule.getCreateAt(),
                    schedule.getModifiedAt()
            );
        });
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
    // 삭제
    public Long deleteSchedule(Long scheduleId) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(scheduleId);
        scheduleRepository.delete(schedule);
        return scheduleId;

    }
    // 조회용 메서드
    public Schedule findSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }

}
