package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputEpisode(
        String name,
        String date,
        UUID episodeType,
        UUID patient
) {}
