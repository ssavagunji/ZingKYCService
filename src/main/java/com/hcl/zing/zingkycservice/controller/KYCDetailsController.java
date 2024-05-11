package com.hcl.zing.zingkycservice.controller;

import com.hcl.zing.zingkycservice.dto.KYCDetailsDTO;
import com.hcl.zing.zingkycservice.entitiy.KYCDetails;
import com.hcl.zing.zingkycservice.repository.UserRepository;
import com.hcl.zing.zingkycservice.services.KYCDetailsService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/kyc")
@Getter
@Setter
public class KYCDetailsController {

    @Autowired
    private KYCDetailsService kycDetailsService;


    @PostMapping("/details")
    public KYCDetailsDTO saveKYCDetails(@RequestBody KYCDetailsDTO kycDetails) {
        System.out.print("Inside SaveKYC");
        return kycDetailsService.saveKYCDetails(kycDetails);
    }

    @GetMapping("/details/{id}")
    public KYCDetailsDTO getKYCDetailsById(@PathVariable Long id) {
        return kycDetailsService.getKYCDetailsById(id);
    }

    @PutMapping("/details")
    public void updateKYCDetails(@RequestBody KYCDetailsDTO kycDetails) {
        kycDetailsService.updateKYCDetails(kycDetails);
    }

    @DeleteMapping("/details/{id}")
    public void deleteKYCDetails(@PathVariable Long id) {
        kycDetailsService.deleteKYCDetails(id);
    }

}
