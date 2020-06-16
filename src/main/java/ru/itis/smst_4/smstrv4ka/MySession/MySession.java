package ru.itis.smst_4.smstrv4ka.MySession;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.itis.smst_4.smstrv4ka.model.User;

@SessionScope
@Data
@Component
public class MySession {
    User user;
}
