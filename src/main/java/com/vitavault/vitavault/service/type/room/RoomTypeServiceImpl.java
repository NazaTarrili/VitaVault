package com.vitavault.vitavault.service.type.room;

import com.vitavault.vitavault.domain.RoomType;
import com.vitavault.vitavault.repository.RoomTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType, RoomTypeRepository> implements IRoomTypeService {
}
