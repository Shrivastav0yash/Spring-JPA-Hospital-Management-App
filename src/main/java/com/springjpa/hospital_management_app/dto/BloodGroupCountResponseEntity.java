package com.springjpa.hospital_management_app.dto;

import com.springjpa.hospital_management_app.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountResponseEntity {

    private BloodGroupType bloodGroupType;
    private Long count;
}
