package ru.itis.smst_4.smstrv4ka;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ru.itis.smst_4.smstrv4ka.Smstrv4kaApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Smstrv4kaApplication.class);
    }

}
