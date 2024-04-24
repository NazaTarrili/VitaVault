package com.vitavault.vitavault.domain;

import com.vitavault.vitavault.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlan extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private float cost;

    @Column(nullable = false)
    private String terms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodicity_id", nullable = false)
    private Periodicity periodicity;
}
