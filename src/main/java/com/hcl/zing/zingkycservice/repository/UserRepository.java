package com.hcl.zing.zingkycservice.repository;

import com.hcl.zing.zingkycservice.entitiy.KYCDetails;
import com.hcl.zing.zingkycservice.entitiy.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {


}
