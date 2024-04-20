package com.sigis.sigis.domain;

import com.sigis.sigis.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillingDetail extends BaseEntity {
    @Column(nullable = false)
    private String taxIdentifier;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "\"reference\"")
    private String reference;

    @Column(nullable = false, unique = true)
    private String iban;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address address;
}
