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
public class Supplier extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address address;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Supply> supplies;
}
