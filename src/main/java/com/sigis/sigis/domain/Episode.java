package com.sigis.sigis.domain;

import com.sigis.sigis.domain.base.BaseEntity;
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
public class Episode extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "episode")
    private Set<EpisodeDetail> episodeDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_type_id", nullable = false)
    private EpisodeType episodeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
