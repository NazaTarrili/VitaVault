package com.vitavault.vitavault.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vitavault.vitavault.model.domain.base.BaseEntity;
import com.vitavault.vitavault.model.types.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Center extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column
    private LocalDateTime subscriptionStart;

    @Column
    private LocalDateTime subscriptionEnd;

    @Column(nullable = false)
    private SubscriptionStatus subscriptionStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_type_id", nullable = false)
    private CenterType centerType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_detail_id", nullable = false, unique = true)
    private BillingDetail billingDetail;

    @OneToMany(mappedBy = "center")
    private Set<User> users;

    @OneToMany(mappedBy = "center")
    private Set<Room> rooms;
}
