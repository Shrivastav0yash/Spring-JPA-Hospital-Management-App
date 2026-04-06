package com.springjpa.hospital_management_app.dto;

import com.springjpa.hospital_management_app.entity.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO {
    private String username;
    private String password;
    private String name;
    private Set<RoleType> roles = new HashSet<>();

}
