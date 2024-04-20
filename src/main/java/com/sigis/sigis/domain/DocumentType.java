package com.sigis.sigis.domain;

import com.sigis.sigis.domain.base.BaseEntity;
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
public class DocumentType extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "documentType")
    private Set<Person> people;
}
