package com.vitavault.vitavault.domain;

import com.vitavault.vitavault.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CenterType extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "centerType")
    private Set<Center> centers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_plan_id", nullable = false)
    private SubscriptionPlan subscriptionPlan;
}
