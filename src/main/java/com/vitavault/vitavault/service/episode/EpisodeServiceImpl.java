package com.vitavault.vitavault.service.episode;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Episode;
import com.vitavault.vitavault.model.input.InputEpisode;
import com.vitavault.vitavault.repository.EpisodeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.patient.IPatientService;
import com.vitavault.vitavault.service.type.episode.IEpisodeTypeService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode, EpisodeRepository> implements IEpisodeService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IEpisodeTypeService episodeTypeService;

    @Autowired
    private IPatientService patientService;

    @Override
    public void create(InputEpisode input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("Episode: name is required.");

        if (!validate.isLocalDateTime(input.date()))
            throw new InvalidRequestException("Episode: date is required.");

        if (!validate.isUUID(input.episodeType()))
            throw new InvalidRequestException("Episode: episode type is required.");

        if (!validate.isUUID(input.patient()))
            throw new InvalidRequestException("Episode: patient is required.");

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
        Episode episode = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Episode: not found ID."));

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
