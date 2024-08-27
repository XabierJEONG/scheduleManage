package com.sparta.schedulemanage.controller;

import com.sparta.schedulemanage.dto.UserDto.UserRequestDto;
import com.sparta.schedulemanage.dto.UserDto.UserResponseDto;
import com.sparta.schedulemanage.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // 등록
    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto responseDto = userService.createUser(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // 단건 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long userId) {
        UserResponseDto responseDto = userService.readUser(userId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 다건 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findUserList() {
        List<UserResponseDto> responseDto = userService.readUserList();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // 수정
    @PutMapping("/user/{userID}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto requestDto) {
        userService.updateUser(userId, requestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //삭제
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
