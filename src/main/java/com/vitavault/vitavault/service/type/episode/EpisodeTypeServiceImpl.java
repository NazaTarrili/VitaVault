package com.vitavault.vitavault.service.type.episode;

import com.vitavault.vitavault.model.domain.EpisodeType;
import com.vitavault.vitavault.model.input.InputEpisodeType;
import com.vitavault.vitavault.repository.EpisodeTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeTypeServiceImpl extends BaseServiceImpl<EpisodeType, EpisodeTypeRepository> implements IEpisodeTypeService {
    @Override
    public void create(InputEpisodeType input) {

    }

    @Override
    public void update(UUID id, InputEpisodeType input) {

    }
}
