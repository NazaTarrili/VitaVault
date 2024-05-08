package com.vitavault.vitavault.model.domain;

import com.vitavault.vitavault.model.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Treatment extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
