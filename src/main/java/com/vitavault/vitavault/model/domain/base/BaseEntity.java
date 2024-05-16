package com.vitavault.vitavault.model.domain.base;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @UuidGenerator
    private UUID id;
}
