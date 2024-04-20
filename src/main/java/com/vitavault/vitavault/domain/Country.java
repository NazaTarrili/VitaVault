package com.vitavault.vitavault.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitavault.vitavault.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private Set<State> states;
}
