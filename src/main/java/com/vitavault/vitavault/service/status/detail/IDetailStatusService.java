package com.vitavault.vitavault.service.status.detail;

import com.vitavault.vitavault.model.domain.DetailStatus;
import com.vitavault.vitavault.model.input.InputDetailStatus;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IDetailStatusService extends IBaseService<DetailStatus>, ICreateUpdate<InputDetailStatus> {
}
