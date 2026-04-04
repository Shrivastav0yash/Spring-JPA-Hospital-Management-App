package com.springjpa.hospital_management_app.security;

import com.springjpa.hospital_management_app.dto.LoginRequestDTO;
import com.springjpa.hospital_management_app.dto.LoginResponseDTO;
import com.springjpa.hospital_management_app.dto.SignupResponseDTO;
import com.springjpa.hospital_management_app.entity.User;
import com.springjpa.hospital_management_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDTO(token, user.getId());
    }

    public SignupResponseDTO signup(LoginRequestDTO signupRequestDTO) {
        User user =  userRepository.findByUsername(signupRequestDTO.getUsername()).orElse(null);

        if(user != null ) throw new IllegalArgumentException("User already exist");

        user = userRepository.save(User.builder()
                        .username(signupRequestDTO.getUsername())
                        .password(passwordEncoder.encode(signupRequestDTO.getPassword()))
                .build());

        return new SignupResponseDTO(user.getId(), user.getUsername());
    }

}
