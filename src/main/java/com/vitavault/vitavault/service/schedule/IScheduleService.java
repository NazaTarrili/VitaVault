package com.vitavault.vitavault.service.schedule;

import com.vitavault.vitavault.model.domain.Schedule;
import com.vitavault.vitavault.model.input.InputSchedule;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IScheduleService extends IBaseService<Schedule>, ICreateUpdate<InputSchedule> {
}
