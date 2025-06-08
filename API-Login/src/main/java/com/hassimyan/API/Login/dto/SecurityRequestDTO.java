package com.hassimyan.API.Login.dto;

import jakarta.validation.constraints.NotEmpty;

public record SecurityRequestDTO(
        @NotEmpty(message = "O parâmetro 'email' não pode ser nulo ou vazio.")
        String email,

        @NotEmpty(message = "O parâmetro 'senha' não pode ser nulo ou vazio.")
        String password
) {}
