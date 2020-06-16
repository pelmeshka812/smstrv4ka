package ru.itis.smst_4.smstrv4ka.service;

import ru.itis.smst_4.smstrv4ka.dto.SignUpDto;
import ru.itis.smst_4.smstrv4ka.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers(Integer page, Integer size, String sort);

    UserDto getUser(Long userId);

    UserDto addUser(SignUpDto userData);
}

