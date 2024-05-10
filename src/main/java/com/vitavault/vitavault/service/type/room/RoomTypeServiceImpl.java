package com.vitavault.vitavault.service.type.room;

import com.vitavault.vitavault.model.domain.RoomType;
import com.vitavault.vitavault.model.input.InputRoomType;
import com.vitavault.vitavault.repository.RoomTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType, RoomTypeRepository> implements IRoomTypeService {
    @Override
    public void create(InputRoomType input) {

    }

    @Override
    public void update(UUID id, InputRoomType input) {

    }
}
