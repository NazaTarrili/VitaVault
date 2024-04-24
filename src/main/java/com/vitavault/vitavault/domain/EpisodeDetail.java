package com.vitavault.vitavault.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EpisodeDetail extends BaseEntity {
    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_id")
    private Bed bed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    @ManyToMany
    @JoinTable(
            name = "EpisodeDetailXSupply",
            joinColumns = @JoinColumn(name = "episodeDetailId"),
            inverseJoinColumns = @JoinColumn(name = "supplyId")
    )
    private Set<Supply> supplies;

    @ManyToMany
    @JoinTable(
            name = "EpisodeDetailXUser",
            joinColumns = @JoinColumn(name = "episodeDetailId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_detail_status_id", nullable = false)
    private DetailStatus episodeDetailStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_id", nullable = false)
    private Episode episode;
}
