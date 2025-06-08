package com.hassimyan.API.Login.controller;

import com.hassimyan.API.Login.dto.ResponseDTO;
import com.hassimyan.API.Login.dto.SecurityRequestDTO;
import com.hassimyan.API.Login.dto.SecurityResponseDTO;
import com.hassimyan.API.Login.security.JwtTokenUtils;
import com.hassimyan.API.Login.security.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("authentication")
public class SecurityController {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody SecurityRequestDTO securityRequestDTO) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            securityRequestDTO.email(),
                            securityRequestDTO.password()
                    )
            );
            UserDetailsCustom userDetailsCuston = (UserDetailsCustom) authentication.getPrincipal();
            String token = jwtTokenUtils.generateToken(userDetailsCuston);
            return ResponseEntity.ok(new SecurityResponseDTO(token));
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO("Credenciais inválidas"));
        }
    }
}
