package com.issuetracker.service;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDto userDto) {
        userRepository.save(userDto.toUser());
    }
}
