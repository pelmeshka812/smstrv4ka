package ru.itis.smst_4.smstrv4ka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import ru.itis.smst_4.smstrv4ka.dto.SignUpDto;
import ru.itis.smst_4.smstrv4ka.model.User;
import ru.itis.smst_4.smstrv4ka.repository.UsersRepository;

import java.time.LocalDateTime;

@Component
@ApplicationScope
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .role("User")
                .createdAt(LocalDateTime.now())
                .build();

        usersRepository.save(user);
    }
}

