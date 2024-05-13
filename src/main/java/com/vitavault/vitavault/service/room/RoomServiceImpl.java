package com.vitavault.vitavault.service.room;

import com.vitavault.vitavault.model.domain.Room;
import com.vitavault.vitavault.model.input.InputRoom;
import com.vitavault.vitavault.repository.RoomRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomRepository> implements IRoomService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputRoom input) {

    }

    @Override
    public void update(UUID id, InputRoom input) {

    }
}
