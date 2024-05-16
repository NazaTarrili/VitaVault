package com.vitavault.vitavault.service.room;

import com.vitavault.vitavault.model.domain.Room;
import com.vitavault.vitavault.model.input.InputRoom;
import com.vitavault.vitavault.repository.RoomRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.center.ICenterService;
import com.vitavault.vitavault.service.type.room.IRoomTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomRepository> implements IRoomService {
    private final String className = Room.class.getName();

    @Autowired
    private IRoomTypeService roomTypeService;

    @Autowired
    private ICenterService centerService;

    @Override
    public void create(InputRoom input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("room type", input.roomType()), className);
        requestValidator.invalidRequest(new Property("center", input.center()), className);

        repository.save(
                Room.builder()
                        .name(input.name())
                        .roomType(roomTypeService.getByID(input.roomType()))
                        .center(centerService.getByID(input.center()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputRoom input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Room room = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            room.setName(input.name());

        if (validate.isUUID(input.roomType()))
            room.setRoomType(roomTypeService.getByID(input.roomType()));

        if (validate.isUUID(input.center()))
            room.setCenter(centerService.getByID(input.center()));

        repository.save(room);
    }
}
