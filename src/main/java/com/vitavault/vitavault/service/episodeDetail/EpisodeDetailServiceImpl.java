package com.vitavault.vitavault.service.episodeDetail;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.EpisodeDetail;
import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputEpisodeDetail;
import com.vitavault.vitavault.repository.EpisodeDetailRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.bed.IBedService;
import com.vitavault.vitavault.service.episode.IEpisodeService;
import com.vitavault.vitavault.service.status.detail.IDetailStatusService;
import com.vitavault.vitavault.service.supply.ISupplyService;
import com.vitavault.vitavault.service.treatment.ITreatmentService;
import com.vitavault.vitavault.service.user.IUserService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EpisodeDetailServiceImpl extends BaseServiceImpl<EpisodeDetail, EpisodeDetailRepository> implements IEpisodeDetailService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IBedService bedService;

    @Autowired
    private ITreatmentService treatmentService;

    @Autowired
    private ISupplyService supplyService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDetailStatusService detailStatusService;

    @Autowired
    private IEpisodeService episodeService;

    @Override
    public void create(InputEpisodeDetail input) {
        if (!validate.isNonEmptyString(input.note()))
            throw new InvalidRequestException("Episode detail: note is required.");

        if (!validate.isUUID(input.treatment()))
            throw new InvalidRequestException("Episode detail: treatment is required.");

        if (!validate.isNonEmptyUUIDList(input.users()))
            throw new InvalidRequestException("Episode detail: users are required.");

        if (!validate.isUUID(input.episodeDetailStatus()))
            throw new InvalidRequestException("Episode detail: episode detail status is required.");

        if (!validate.isUUID(input.episode()))
            throw new InvalidRequestException("Episode detail: episode is required.");

        Set<Supply> supplies = input.supplies().stream().map(supplyService::getByID).collect(Collectors.toSet());

        Set<User> users = input.users().stream().map(userService::getByID).collect(Collectors.toSet());

        repository.save(
                EpisodeDetail.builder()
                        .note(input.note())
                        .date(input.date())
                        .bed(bedService.getByID(input.bed()))
                        .treatment(treatmentService.getByID(input.treatment()))
                        .supplies(supplies)
                        .users(users)
                        .episodeDetailStatus(detailStatusService.getByID(input.episodeDetailStatus()))
                        .episode(episodeService.getByID(input.episode()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputEpisodeDetail input) {
        EpisodeDetail episodeDetail = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Episode detail: not found ID."));

        if (validate.isNonEmptyString(input.note()))
            episodeDetail.setNote(input.note());

        if (validate.isLocalDateTime(input.date()))
            episodeDetail.setDate(input.date());

        if (validate.isUUID(input.bed()))
            episodeDetail.setBed(bedService.getByID(input.bed()));

        if (validate.isUUID(input.treatment()))
            episodeDetail.setTreatment(treatmentService.getByID(input.treatment()));

        if (validate.isNonEmptyUUIDList(input.supplies())) {
            Set<Supply> supplies = input.supplies().stream().map(supplyService::getByID).collect(Collectors.toSet());
            episodeDetail.setSupplies(supplies);
        }

        if (validate.isNonEmptyUUIDList(input.users())) {
            Set<User> users = input.users().stream().map(userService::getByID).collect(Collectors.toSet());
            episodeDetail.setUsers(users);
        }

        if (validate.isUUID(input.episodeDetailStatus()))
            episodeDetail.setEpisodeDetailStatus(detailStatusService.getByID(input.episodeDetailStatus()));

        if (validate.isUUID(input.episode()))
            episodeDetail.setEpisode(episodeService.getByID(input.episode()));

        repository.save(episodeDetail);
    }
}
