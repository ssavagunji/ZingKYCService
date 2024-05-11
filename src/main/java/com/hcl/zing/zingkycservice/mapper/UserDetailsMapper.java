package com.hcl.zing.zingkycservice.mapper;

import com.hcl.zing.zingkycservice.dto.UserDetailsDTO;
import com.hcl.zing.zingkycservice.entitiy.UserDetails;

public class UserDetailsMapper {


    public static UserDetailsDTO toDTO(UserDetails userDetails){
        if (userDetails == null) {
            return null;
        }

        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setUserId(userDetails.getUserId());
        dto.setFullName(userDetails.getFullName());
        dto.setDateOfBirth(userDetails.getDateOfBirth());
        dto.setAddress(userDetails.getAddress());
        dto.setNationality(userDetails.getNationality());

        return dto;
    }

    public static UserDetails toEntity(UserDetailsDTO dto){
        if (dto == null) {
            return null;
        }

        UserDetails entity = new UserDetails();
        entity.setUserId(dto.getUserId());
        entity.setFullName(dto.getFullName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAddress(dto.getAddress());
        entity.setNationality(dto.getNationality());

        return entity;
    }
}

