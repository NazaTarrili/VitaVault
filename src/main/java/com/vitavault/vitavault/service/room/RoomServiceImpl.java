package com.vitavault.vitavault.service.room;

import com.vitavault.vitavault.model.domain.Room;
import com.vitavault.vitavault.repository.RoomRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomRepository> implements IRoomService {
}
