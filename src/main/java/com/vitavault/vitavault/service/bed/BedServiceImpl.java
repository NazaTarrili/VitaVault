package com.vitavault.vitavault.service.bed;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.Bed;
import com.vitavault.vitavault.model.input.InputBed;
import com.vitavault.vitavault.repository.BedRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.room.IRoomService;
import com.vitavault.vitavault.service.status.bed.IBedStatusService;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BedServiceImpl extends BaseServiceImpl<Bed, BedRepository> implements IBedService {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IBedStatusService bedStatusService;

    @Autowired
    private IRoomService roomService;

    @Override
    public void create(InputBed input) {
        if (!validate.isNonEmptyString(input.name()))
            throw new InvalidRequestException("Bed: name is required.");

        if (!validate.isUUID(input.bedStatus()))
            throw new InvalidRequestException("Bed: bed status is required.");

        if (!validate.isUUID(input.room()))
            throw new InvalidRequestException("Bed: room is required.");

        repository.save(
                Bed.builder()
                        .name(input.name())
                        .bedStatus(bedStatusService.getByID(input.bedStatus()))
                        .room(roomService.getByID(input.room()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputBed input) {
        Bed bed = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Bed: not found ID."));

        if (validate.isNonEmptyString(input.name()))
            bed.setName(input.name());

        if (validate.isUUID(input.bedStatus()))
            bed.setBedStatus(bedStatusService.getByID(input.bedStatus()));

        if (validate.isUUID(input.room()))
            bed.setRoom(roomService.getByID(input.room()));

        repository.save(bed);
    }
}
