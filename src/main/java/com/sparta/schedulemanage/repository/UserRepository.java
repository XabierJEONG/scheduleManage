package com.sparta.schedulemanage.repository;

import com.sparta.schedulemanage.entity.Comment;
import com.sparta.schedulemanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findAllByOrderByModifiedAtDesc();
}
