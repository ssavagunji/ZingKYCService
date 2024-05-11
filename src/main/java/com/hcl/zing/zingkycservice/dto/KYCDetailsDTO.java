package com.hcl.zing.zingkycservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KYCDetailsDTO {

    private Long id;
    private UserDetailsDTO userDetail;
    private String documentType;
    private String documentNumber;
    private String kycStatus;

    // Constructors, getters, and setters
}