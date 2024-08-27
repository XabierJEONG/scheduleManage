package com.sparta.schedulemanage.service;

import com.sparta.schedulemanage.dto.UserDto.UserRequestDto;
import com.sparta.schedulemanage.dto.UserDto.UserResponseDto;
import com.sparta.schedulemanage.entity.User;
import com.sparta.schedulemanage.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // 등록
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(requestDto);
        User saveUser = userRepository.save(user);
        return new UserResponseDto(saveUser);
    }
    // 단건 조회
    public UserResponseDto readUser(Long userId) {
        User user = findById(userId);
        return new UserResponseDto(user);
    }
    // 다건 조회
    public List<UserResponseDto> readUserList() {
        return userRepository.findAllByOrderByModifiedAtDesc().stream().map(UserResponseDto::new).toList();
    }
    // 수정
    @Transactional
    public Long updateUser(Long userId, UserRequestDto requestDto) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 유저는 존재하지 않습니다.")
        );
        user.update(requestDto);
        return userId;
    }
    // 삭제
    public Long deleteUser(Long userId) {
        User user = findById(userId);
        userRepository.delete(user);
        return userId;
    }
    // 조회용메서드
    private User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 유저는 존재하지 않습니다.")
        );
    }

}
