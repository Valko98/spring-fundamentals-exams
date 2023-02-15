package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.UserLoginDTO;
import com.example.shoppinglist.utils.LoggedUser;
import com.example.shoppinglist.models.User;
import com.example.shoppinglist.models.dtos.UserRegistrationDTO;
import com.example.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if(byUsername.isPresent()) {
            return false;
        }


        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setEmail(registrationDTO.getEmail());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> byUsername = this.userRepository.findByUsername(loginDTO.getUsername());
        if(byUsername.isPresent()) {
            String encodedPassword = byUsername.get().getPassword();
            String rawPassword = loginDTO.getPassword();
            if(passwordEncoder.matches(rawPassword, encodedPassword)) {
                this.loggedUser.login(byUsername.get());
                return true;
            }
            return false;

        }

        return false;
    }

    public boolean isLogged() {
        return this.loggedUser.isLogged();
    }
    public void logout() {
        this.loggedUser.logout();
    }

    public long getLoggedUserId() {
        return this.loggedUser.getId();
    }


}
