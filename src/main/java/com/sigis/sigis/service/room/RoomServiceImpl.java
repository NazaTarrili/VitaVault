package com.sigis.sigis.service.room;

import com.sigis.sigis.domain.Room;
import com.sigis.sigis.repository.RoomRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomRepository> implements IRoomService {
}
