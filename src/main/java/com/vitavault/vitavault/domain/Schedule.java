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
public class Schedule extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "schedule")
    private Set<Availability> availabilities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Specialty speciality;

    @OneToMany(mappedBy = "schedule")
    private Set<Appointment> appointments;
}
