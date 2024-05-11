package com.hcl.zing.zingkycservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {

    private Long userId;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String nationality;

    // Constructors, getters, and setters
}
