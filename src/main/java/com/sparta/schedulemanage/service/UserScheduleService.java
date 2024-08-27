package com.sparta.schedulemanage.service;

import com.sparta.schedulemanage.dto.UserScheduleDto.UserScheduleRequestDto;
import com.sparta.schedulemanage.dto.UserScheduleDto.UserScheduleResponseDto;
import com.sparta.schedulemanage.entity.Schedule;
import com.sparta.schedulemanage.entity.User;
import com.sparta.schedulemanage.entity.UserSchedule;
import com.sparta.schedulemanage.repository.ScheduleRepository;
import com.sparta.schedulemanage.repository.UserRepository;
import com.sparta.schedulemanage.repository.UserScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserScheduleService {
    private final UserScheduleRepository userScheduleRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public UserScheduleService(UserScheduleRepository userScheduleRepository, UserRepository userRepository, ScheduleRepository scheduleRepository) {
        this.userScheduleRepository = userScheduleRepository;
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
    }
    // 관계 생성
    public UserScheduleResponseDto createUserSchedule(UserScheduleRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));

        UserSchedule userSchedule = new UserSchedule(user, schedule);
        userScheduleRepository.save(userSchedule);
        return new UserScheduleResponseDto(userSchedule);
    }
    // 관계 조회
    public List<UserScheduleResponseDto> getUserSchedulesByScheduleId(Long scheduleId) {
        List<UserSchedule> userSchedules = userScheduleRepository.findBySchedule_ScheduleId(scheduleId);
        return userSchedules.stream().map(UserScheduleResponseDto::new).collect(Collectors.toList());
    }
    // 관계 삭제
    public void deleteUserSchedule(Long id) {
        userScheduleRepository.deleteById(id);
    }
}
