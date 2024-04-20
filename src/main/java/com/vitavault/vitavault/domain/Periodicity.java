package com.vitavault.vitavault.domain;

import com.vitavault.vitavault.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Periodicity extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    @Column(nullable = false)
    private LocalTime start;

    @Column(nullable = false)
    private LocalTime end;
}
