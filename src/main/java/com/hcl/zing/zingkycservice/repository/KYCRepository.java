package com.hcl.zing.zingkycservice.repository;

import com.hcl.zing.zingkycservice.entitiy.KYCDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KYCRepository extends JpaRepository<KYCDetails, Long> {
    // You can define custom query methods here if needed

    Optional<KYCDetails> findByDocumentNumber(String documentNumber);
}
