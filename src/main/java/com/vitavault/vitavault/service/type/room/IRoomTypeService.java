package com.vitavault.vitavault.service.type.room;

import com.vitavault.vitavault.model.domain.RoomType;
import com.vitavault.vitavault.model.input.InputRoomType;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IRoomTypeService extends IBaseService<RoomType>, ICreateUpdate<InputRoomType> {
}
