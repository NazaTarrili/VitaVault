package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

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
) implements BaseInput {
    @Override
    public boolean hasData() {
        return note != null ||
                date != null ||
                bed != null ||
                treatment != null ||
                supplies != null ||
                users != null ||
                episodeDetailStatus != null ||
                episode != null;
    }
}
