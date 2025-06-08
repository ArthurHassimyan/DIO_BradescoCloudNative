package com.hassimyan.API.Login.service;

import com.hassimyan.API.Login.dto.ResponseDTO;
import com.hassimyan.API.Login.dto.UserRequestDTO;
import com.hassimyan.API.Login.model.UserModel;
import com.hassimyan.API.Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.View;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<ResponseDTO> createUser(UserRequestDTO userDTO) {
        userRepository.findByEmail(userDTO.email()).ifPresent(error -> {
            throw new RuntimeException("User already exists");
        });
        String encodedPassword = passwordEncoder.encode(userDTO.password());
        UserModel userModel = new UserModel(userDTO.name() ,userDTO.email(), encodedPassword);
        userRepository.save(userModel);
        return new ResponseEntity<>(new ResponseDTO("User created successfully"), HttpStatus.CREATED);
    }

    private void updateUser(UserModel userModel, UserRequestDTO userDTO) {
        userModel.setEmail(userDTO.email());
        userModel.setUsername(userDTO.name());
        userModel.setPassword(userDTO.password());
        userRepository.save(userModel);
    }

    public ResponseEntity<ResponseDTO> updateUser(UserRequestDTO userDTO, String email) {
        UserModel userModel = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found"));

        if(!userModel.getEmail().equals(userDTO.email())) {
            userRepository.findByEmail(userDTO.email()).ifPresent(error -> {
                throw new RuntimeException("Email already exists");
            });
        }
        updateUser(userModel, userDTO);
        return new ResponseEntity<>(new ResponseDTO("User updated successfully"), HttpStatus.OK);
    }
}
