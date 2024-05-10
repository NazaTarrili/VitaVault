package com.vitavault.vitavault.service.room;

import com.vitavault.vitavault.model.domain.Room;
import com.vitavault.vitavault.model.input.InputRoom;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IRoomService extends IBaseService<Room>, ICreateUpdate<InputRoom> {
}
