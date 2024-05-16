package com.vitavault.vitavault.service.episode;

import com.vitavault.vitavault.model.domain.Episode;
import com.vitavault.vitavault.model.input.InputEpisode;
import com.vitavault.vitavault.repository.EpisodeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.patient.IPatientService;
import com.vitavault.vitavault.service.type.episode.IEpisodeTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode, EpisodeRepository> implements IEpisodeService {
    private final String className = Episode.class.getName();

    @Autowired
    private IEpisodeTypeService episodeTypeService;

    @Autowired
    private IPatientService patientService;

    @Override
    public void create(InputEpisode input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("date", input.date()), className);
        requestValidator.invalidRequest(new Property("episode type", input.episodeType()), className);
        requestValidator.invalidRequest(new Property("patient", input.patient()), className);

        repository.save(
                Episode.builder()
                        .name(input.name())
                        .date(input.date())
                        .episodeType(episodeTypeService.getByID(input.episodeType()))
                        .patient(patientService.getByID(input.patient()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputEpisode input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Episode episode = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            episode.setName(input.name());

        if (validate.isLocalDateTime(input.date()))
            episode.setDate(input.date());

        if (validate.isUUID(input.episodeType()))
            episode.setEpisodeType(episodeTypeService.getByID(input.episodeType()));

        if (validate.isUUID(input.patient()))
            episode.setPatient(patientService.getByID(input.patient()));

        repository.save(episode);
    }
}
