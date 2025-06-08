package com.hassimyan.API.Login.controller;

import com.hassimyan.API.Login.dto.ResponseDTO;
import com.hassimyan.API.Login.dto.UserRequestDTO;
import com.hassimyan.API.Login.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid UserRequestDTO userRequestDTO ) {
        return userService.createUser(userRequestDTO);
    }

    @PutMapping("/{email}")
    @PreAuthorize("#email == principal.email")
    public ResponseEntity<ResponseDTO> email(@PathVariable String email, @RequestBody @Valid UserRequestDTO userRequestDTO) {
        return userService.updateUser(userRequestDTO, email);
    }
}