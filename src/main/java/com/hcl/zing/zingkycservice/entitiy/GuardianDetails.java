package com.hcl.zing.zingkycservice.entitiy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "zing_guardian_details")
@Getter
@Setter
public class GuardianDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails userDetail;

    @Column(name = "guardian_name", nullable = false)
    private String guardianName;

    @Column(name = "relationship", nullable = false)
    private String relationship;

}