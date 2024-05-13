package com.vitavault.vitavault.model.input;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record InputEpisodeDetail(
        String note,
        LocalDateTime date,
        UUID bed,
        UUID treatment,
        List<UUID> supplies,
        List<UUID> users,
        UUID episodeDetailStatus,
        UUID episode
) {}
