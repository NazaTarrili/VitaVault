package com.vitavault.vitavault.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vitavault.vitavault.model.domain.base.BaseEntity;
import com.vitavault.vitavault.model.types.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDateTime birthdate;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private Patient patient;
}
