package com.vitavault.vitavault.domain;

import com.vitavault.vitavault.domain.base.BaseEntity;
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
public class Supply extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    @Column(nullable = false)
    private Integer minimalStock;

    @OneToMany(mappedBy = "supply")
    private Set<DeliveryNote> deliveryNotes;

    @ManyToMany
    @JoinTable(
            name = "SupplyXSupplier",
            joinColumns = @JoinColumn(name = "supplyId"),
            inverseJoinColumns = @JoinColumn(name = "supplierId")
    )
    private Set<Supplier> suppliers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supply_type_id", nullable = false)
    private SupplyType supplyType;

    @ManyToMany(mappedBy = "supplies")
    private Set<EpisodeDetail> episodeDetails;
}
