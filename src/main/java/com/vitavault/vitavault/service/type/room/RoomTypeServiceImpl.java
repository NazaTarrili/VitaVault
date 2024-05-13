package com.vitavault.vitavault.service.type.room;

import com.vitavault.vitavault.model.domain.RoomType;
import com.vitavault.vitavault.model.input.InputRoomType;
import com.vitavault.vitavault.repository.RoomTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType, RoomTypeRepository> implements IRoomTypeService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputRoomType input) {

    }

    @Override
    public void update(UUID id, InputRoomType input) {

    }
}
