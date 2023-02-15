package com.example.shoppinglist.utils;

import com.example.shoppinglist.models.User;
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

    private Long id;
    private String username;

    public void login(User user) {
        this.id = getId();
        this.username = user.getUsername();
    }
    public void logout() {
        this.id = null;
        this.username = null;
    }

    public boolean isLogged() {
        return this.getId() != null;
    }
}
