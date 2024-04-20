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
public class Plan extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_work_id", nullable = false)
    private SocialWork socialWork;

    @OneToMany(mappedBy = "plan")
    private Set<Patient> patients;
}
