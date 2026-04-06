package com.springjpa.hospital_management_app.controller;

import com.springjpa.hospital_management_app.dto.LoginRequestDTO;
import com.springjpa.hospital_management_app.dto.LoginResponseDTO;
import com.springjpa.hospital_management_app.dto.SignupRequestDTO;
import com.springjpa.hospital_management_app.dto.SignupResponseDTO;
import com.springjpa.hospital_management_app.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return new ResponseEntity<>(authService.login(loginRequestDTO), HttpStatus.OK);

    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO){
        return new ResponseEntity<>(authService.signup(signupRequestDTO), HttpStatus.OK);

    }
}
