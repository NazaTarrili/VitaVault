package com.vitavault.vitavault.service.plan;

import com.vitavault.vitavault.model.domain.Plan;
import com.vitavault.vitavault.model.input.InputPlan;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IPlanService extends IBaseService<Plan>, ICreateUpdate<InputPlan> {
}
