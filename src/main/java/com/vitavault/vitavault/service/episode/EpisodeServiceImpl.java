package com.vitavault.vitavault.service.episode;

import com.vitavault.vitavault.model.domain.Episode;
import com.vitavault.vitavault.model.input.InputEpisode;
import com.vitavault.vitavault.repository.EpisodeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode, EpisodeRepository> implements IEpisodeService {
    @Override
    public void create(InputEpisode input) {

    }

    @Override
    public void update(UUID id, InputEpisode input) {

    }
}
