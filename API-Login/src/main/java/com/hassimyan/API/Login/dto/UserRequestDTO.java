package com.hassimyan.API.Login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
    @NotEmpty(message = "O parâmetro 'name' não pode ser nulo ou vazio.")
    @Size(min = 4, message = "O nome deve conter no mínimo 4 caracteres.")
    @Size(max = 255, message = "Número máximo de caracteres para 'name' excedido!")
    String name,

    @NotEmpty(message = "O parâmetro 'email' não pode ser nulo ou vazio.")
    @Email(message = "E-mail inválido, tente outro!")
    @Size(max = 320, message = "Número máximo de caracteres para 'email' excedido!")
    String email,

    @NotEmpty(message = "O parâmetro 'senha' não pode ser nulo ou vazio.")
    @Size(min = 8, message = "A senha  deve conter no mínimo 8 caracteres.")
    @Size(max = 255, message = "Número máximo de caracteres para 'senha' excedido!")
    String password) {
}
