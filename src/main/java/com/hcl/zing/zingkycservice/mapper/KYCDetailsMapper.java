package com.hcl.zing.zingkycservice.mapper;

import com.hcl.zing.zingkycservice.dto.KYCDetailsDTO;
import com.hcl.zing.zingkycservice.entitiy.KYCDetails;

public class KYCDetailsMapper {



    public static KYCDetailsDTO toDTO(KYCDetails kycDetails){
        if (kycDetails == null) {
            return null;
        }

        KYCDetailsDTO dto = new KYCDetailsDTO();
        dto.setId(kycDetails.getId());
        dto.setDocumentType(kycDetails.getDocumentType());
        dto.setDocumentNumber(kycDetails.getDocumentNumber());
        dto.setKycStatus(kycDetails.getKycStatus());

        if(kycDetails.getUserDetail()!=null){
            dto.setUserDetail(UserDetailsMapper.toDTO(kycDetails.getUserDetail()));
        }

        return dto;
    }

    public static KYCDetails toEntity(KYCDetailsDTO dto){
        if (dto == null) {
            return null;
        }

        KYCDetails entity = new KYCDetails();
        entity.setId(dto.getId());
        entity.setDocumentType(dto.getDocumentType());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setKycStatus(dto.getKycStatus());

        if(dto.getUserDetail()!=null){
            entity.setUserDetail(UserDetailsMapper.toEntity(dto.getUserDetail()));
        }
        // Map userDetail using UserDetailsMapper or manually map the fields

        return entity;
    }
}

