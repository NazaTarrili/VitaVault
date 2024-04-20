package com.sigis.sigis.service.subscriptionPlan;

import com.sigis.sigis.domain.SubscriptionPlan;
import com.sigis.sigis.repository.SubscriptionPlanRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionPlanServiceImpl extends BaseServiceImpl<SubscriptionPlan, SubscriptionPlanRepository> implements ISubscriptionPlanService {
}
