package ru.itis.smst_4.smstrv4ka.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.smst_4.smstrv4ka.MySession.MySession;
import ru.itis.smst_4.smstrv4ka.model.User;
import ru.itis.smst_4.smstrv4ka.repository.UsersRepository;

import java.util.Optional;

@Service(value = "myUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepository userRepository;
    @Autowired
    MySession session;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findUserByEmail(login);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            session.setUser(user);
            return new ru.itis.smst_4.smstrv4ka.security.details.UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
