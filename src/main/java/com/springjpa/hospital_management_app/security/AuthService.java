package com.springjpa.hospital_management_app.security;

import com.springjpa.hospital_management_app.dto.LoginRequestDTO;
import com.springjpa.hospital_management_app.dto.LoginResponseDTO;
import com.springjpa.hospital_management_app.dto.SignupRequestDTO;
import com.springjpa.hospital_management_app.dto.SignupResponseDTO;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.entity.User;
import com.springjpa.hospital_management_app.entity.type.AuthProviderType;
import com.springjpa.hospital_management_app.entity.type.RoleType;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import com.springjpa.hospital_management_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;

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

    public User signUpInternal(SignupRequestDTO signupRequestDTO, AuthProviderType authProviderType, String providerId){
        User user =  userRepository.findByUsername(signupRequestDTO.getUsername()).orElse(null);

        if(user != null ) throw new IllegalArgumentException("User already exist");

        user  = User.builder()
                .username(signupRequestDTO.getUsername())
                .providerId(providerId)
                .providerType(authProviderType)
                .roles(signupRequestDTO.getRoles())
                //.roles(Set.of(RoleType.PATIENT))
                .build();

        if(authProviderType == AuthProviderType.EMAIL) {
            user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
        }

        user  = userRepository.save(user);

        Patient patient = Patient.builder()
                .name(signupRequestDTO.getName())
                .email(signupRequestDTO.getUsername())
                .user(user)
                .build();

        patientRepository.save(patient);

        return user;
    }

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO) {
        User user = signUpInternal(signupRequestDTO, AuthProviderType.EMAIL, null);
        return new SignupResponseDTO(user.getId(), user.getUsername());
    }

    @Transactional
    public ResponseEntity<LoginResponseDTO> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {
        //provider Tyoe and provider ID
        AuthProviderType providerType = authUtil.getProviderTypeFromRegistration(registrationId);
        String providerId = authUtil.determineProviderIdFromOAuth2User(oAuth2User, registrationId);

        User user = userRepository.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        String email = oAuth2User.getAttribute("email");

        String name = oAuth2User.getAttribute("name");



        User emailUser = userRepository.findByUsername(email).orElse(null);

        if(user == null &&  emailUser == null){
            //sign up flow
            String username = authUtil.determineUsernameFromOAuth2User(oAuth2User, registrationId, providerId);
            user = signUpInternal(new SignupRequestDTO(
                username, null, name, Set.of(RoleType.PATIENT)
            ),providerType, providerId);
        }
        else if (user != null){
            if(email != null && !email.isBlank() && !email.equals(user.getUsername())){
                user.setUsername(email);
                userRepository.save(user);
            }
        }
        else {
            throw new BadCredentialsException("This email already register "+email);
        }

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(authUtil.generateAccessToken(user), user.getId());

        return ResponseEntity.ok(loginResponseDTO);
    }
}
