package com.example.webexam.utils;

import com.example.webexam.models.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor
@Component
@SessionScope
public class LoggedUser {

    private long id;
    private String username;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
    public void logout() {
        this.id = 0;
        this.username = null;
    }

    public boolean isLogged() {
        return this.getId() != 0;
    }
}