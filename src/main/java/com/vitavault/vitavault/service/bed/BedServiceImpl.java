package com.vitavault.vitavault.service.bed;

import com.vitavault.vitavault.model.domain.Bed;
import com.vitavault.vitavault.model.input.InputBed;
import com.vitavault.vitavault.repository.BedRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.room.IRoomService;
import com.vitavault.vitavault.service.status.bed.IBedStatusService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BedServiceImpl extends BaseServiceImpl<Bed, BedRepository> implements IBedService {
    private final String className = Bed.class.getName();

    @Autowired
    private IBedStatusService bedStatusService;

    @Autowired
    private IRoomService roomService;

    @Override
    public void create(InputBed input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("bed status", input.bedStatus()), className);
        requestValidator.invalidRequest(new Property("room", input.room()), className);

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
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Bed bed = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            bed.setName(input.name());

        if (validate.isUUID(input.bedStatus()))
            bed.setBedStatus(bedStatusService.getByID(input.bedStatus()));

        if (validate.isUUID(input.room()))
            bed.setRoom(roomService.getByID(input.room()));

        repository.save(bed);
    }
}
