package com.vitavault.vitavault.service.type.room;

import com.vitavault.vitavault.model.domain.RoomType;
import com.vitavault.vitavault.model.input.InputRoomType;
import com.vitavault.vitavault.repository.RoomTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType, RoomTypeRepository> implements IRoomTypeService {
    private final String className = RoomType.class.getName();

    @Override
    public void create(InputRoomType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new RoomType(input.name()));
    }

    @Override
    public void update(UUID id, InputRoomType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        RoomType roomType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            roomType.setName(input.name());

        repository.save(roomType);
    }
}
