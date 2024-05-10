package com.vitavault.vitavault.service.status.bed;

import com.vitavault.vitavault.model.domain.BedStatus;
import com.vitavault.vitavault.model.input.InputBedStatus;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IBedStatusService extends IBaseService<BedStatus>, ICreateUpdate<InputBedStatus> {
}
