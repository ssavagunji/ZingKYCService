package com.hcl.zing.zingkycservice.services;

import com.hcl.zing.zingkycservice.dto.KYCDetailsDTO;
import com.hcl.zing.zingkycservice.entitiy.KYCDetails;
import com.hcl.zing.zingkycservice.exception.ValueNotFoundException;
import com.hcl.zing.zingkycservice.mapper.KYCDetailsMapper;
import com.hcl.zing.zingkycservice.repository.KYCRepository;
import com.hcl.zing.zingkycservice.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@Getter
@Setter
public class KYCDetailsService {

    @Autowired
    private KYCRepository kycRepository;

    @Autowired
    private UserRepository userRepository;



    public KYCDetailsDTO saveKYCDetails(KYCDetailsDTO kycDetailsDto) {
        KYCDetails kycDetails = KYCDetailsMapper.toEntity(kycDetailsDto);
        userRepository.save(kycDetails.getUserDetail());
        KYCDetails kycDetails2 = kycRepository.save(kycDetails);

        KYCDetailsDTO kycDetailsDTO = KYCDetailsMapper.toDTO(kycDetails2);

        return kycDetailsDTO;
    }

    public KYCDetailsDTO getKYCDetailsById(Long id) {
        Optional<KYCDetails> kycDetails2 = kycRepository.findById(id);
        if(kycDetails2.isEmpty()){
            throw new ValueNotFoundException("No User available with this ID");
        }
        KYCDetailsDTO kycDetailsDTO = KYCDetailsMapper.toDTO(kycDetails2.get());
        return kycDetailsDTO;
    }



    public void updateKYCDetails(KYCDetailsDTO kycDetailsDto) {
        KYCDetails kycDetails = KYCDetailsMapper.toEntity(kycDetailsDto);
        userRepository.save(kycDetails.getUserDetail());
        KYCDetails kycDetails2 = kycRepository.save(kycDetails);

        KYCDetailsDTO kycDetailsDTO = KYCDetailsMapper.toDTO(kycDetails2);
    }

    public void deleteKYCDetails(Long id) {
        kycRepository.deleteById(id);
    }
}
