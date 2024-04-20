package com.sigis.sigis.domain;

import com.sigis.sigis.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Boolean finished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
