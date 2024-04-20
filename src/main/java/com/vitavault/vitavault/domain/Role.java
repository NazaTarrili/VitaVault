package com.vitavault.vitavault.domain;

import com.vitavault.vitavault.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;


@Table(name = "\"Role\"")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
