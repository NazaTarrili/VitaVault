package com.vitavault.vitavault.service.subscriptionPlan;

import com.vitavault.vitavault.model.domain.SubscriptionPlan;
import com.vitavault.vitavault.model.input.InputSubscriptionPlan;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISubscriptionPlanService extends IBaseService<SubscriptionPlan>, ICreateUpdate<InputSubscriptionPlan> {
}
