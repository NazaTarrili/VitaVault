package com.vitavault.vitavault.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vitavault.vitavault.model.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Address extends BaseEntity {
    @Column
    private Integer number;

    @Column(length = 3)
    private String floor;

    @Column(length = 3)
    private String department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Person> people;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Center center;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private SocialWork socialWork;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Supplier supplier;
}
