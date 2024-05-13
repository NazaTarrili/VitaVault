package com.vitavault.vitavault.model.input;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputEpisode(
        String name,
        LocalDateTime date,
        UUID episodeType,
        UUID patient
) {}
