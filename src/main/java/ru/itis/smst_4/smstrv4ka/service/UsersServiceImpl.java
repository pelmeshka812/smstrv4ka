package ru.itis.smst_4.smstrv4ka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itis.smst_4.smstrv4ka.dto.SignUpDto;
import ru.itis.smst_4.smstrv4ka.dto.UserDto;
import ru.itis.smst_4.smstrv4ka.model.User;
import ru.itis.smst_4.smstrv4ka.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<UserDto> getAllUsers(Integer page, Integer size, String property) {
        Sort sort = Sort.by(property);
        PageRequest request = PageRequest.of(page, size, sort);
        Page<User> pageResult = usersRepository.findAll(request);
        List<User> users = pageResult.getContent();
        return UserDto.from(users);
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.getOne(userId));
    }

    @Override
    public UserDto addUser(SignUpDto userData) {
        User user = User.builder()
                .email(userData.getEmail())
                .password(userData.getPassword())
                .name(userData.getName())
                .createdAt(LocalDateTime.now())
                .build();

        usersRepository.save(user);
        return UserDto.from(user);
    }
}
