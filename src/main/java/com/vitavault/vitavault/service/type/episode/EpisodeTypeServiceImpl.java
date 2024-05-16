package com.vitavault.vitavault.service.type.episode;

import com.vitavault.vitavault.model.domain.EpisodeType;
import com.vitavault.vitavault.model.input.InputEpisodeType;
import com.vitavault.vitavault.repository.EpisodeTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeTypeServiceImpl extends BaseServiceImpl<EpisodeType, EpisodeTypeRepository> implements IEpisodeTypeService {
    private final String className = EpisodeType.class.getName();

    @Override
    public void create(InputEpisodeType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new EpisodeType(input.name()));
    }

    @Override
    public void update(UUID id, InputEpisodeType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        EpisodeType episodeType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            episodeType.setName(input.name());

        repository.save(episodeType);
    }
}
