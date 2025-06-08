package com.hassimyan.API.Login.controller;

import com.hassimyan.API.Login.dto.UserRequestDTO;
import com.hassimyan.API.Login.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterUser() throws Exception {
        UserRequestDTO dto = new UserRequestDTO("TesteUser", "teste@example.com", "senha1234");

        Mockito.when(userService.createUser(any(UserRequestDTO.class)))
                .thenReturn(ResponseEntity.status(201)
                        .body(new com.hassimyan.API.Login.dto.ResponseDTO("User created successfully")));

        mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserRequestDTO dto = new UserRequestDTO("UserUpdate", "userupdate@example.com", "senha1234");

        Mockito.when(userService.updateUser(any(UserRequestDTO.class), eq("userupdate@example.com")))
                .thenReturn(ResponseEntity.ok(new com.hassimyan.API.Login.dto.ResponseDTO("User updated successfully")));

        mockMvc.perform(post("/users/userupdate@example.com")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }
}
