package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputEpisode(
        String name,
        LocalDateTime date,
        UUID episodeType,
        UUID patient
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                date != null ||
                episodeType != null ||
                patient != null;
    }
}
