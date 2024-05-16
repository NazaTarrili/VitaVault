package com.vitavault.vitavault.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vitavault.vitavault.model.domain.base.BaseEntity;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DeliveryNoteType extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "deliveryNoteType")
    private Set<DeliveryNote> deliveryNotes;

    public DeliveryNoteType(String name) {
        this.name = name;
    }
}
