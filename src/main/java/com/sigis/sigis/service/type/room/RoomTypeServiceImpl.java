package com.sigis.sigis.service.type.room;

import com.sigis.sigis.domain.RoomType;
import com.sigis.sigis.repository.RoomTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType, RoomTypeRepository> implements IRoomTypeService {
}
