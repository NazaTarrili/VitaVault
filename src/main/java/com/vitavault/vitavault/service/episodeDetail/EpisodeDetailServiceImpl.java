package com.vitavault.vitavault.service.episodeDetail;

import com.vitavault.vitavault.model.domain.EpisodeDetail;
import com.vitavault.vitavault.model.input.InputEpisodeDetail;
import com.vitavault.vitavault.repository.EpisodeDetailRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeDetailServiceImpl extends BaseServiceImpl<EpisodeDetail, EpisodeDetailRepository> implements IEpisodeDetailService {
    @Override
    public void create(InputEpisodeDetail input) {

    }

    @Override
    public void update(UUID id, InputEpisodeDetail input) {

    }
}
