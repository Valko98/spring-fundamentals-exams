package com.example.webexam.services;

import com.example.webexam.models.dtos.UserLoginDTO;
import com.example.webexam.models.dtos.UserRegistrationDTO;
import com.example.webexam.models.entities.User;
import com.example.webexam.repositories.UserRepository;
import com.example.webexam.utils.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }
        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if(byEmail.isPresent()) {
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if(byUsername.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);

        return true;

    }
    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(user.isEmpty()) {
            return false;
        }
        this.loggedUser.login(user.get());

        return true;
    }

    public boolean isLogged() {
        return this.loggedUser.isLogged();
    }
    public void logout() {
        this.loggedUser.logout();


    }
}
