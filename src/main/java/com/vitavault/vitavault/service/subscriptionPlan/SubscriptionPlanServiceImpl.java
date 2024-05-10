package com.vitavault.vitavault.service.subscriptionPlan;

import com.vitavault.vitavault.model.domain.SubscriptionPlan;
import com.vitavault.vitavault.model.input.InputSubscriptionPlan;
import com.vitavault.vitavault.repository.SubscriptionPlanRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SubscriptionPlanServiceImpl extends BaseServiceImpl<SubscriptionPlan, SubscriptionPlanRepository> implements ISubscriptionPlanService {
    @Override
    public void create(InputSubscriptionPlan input) {

    }

    @Override
    public void update(UUID id, InputSubscriptionPlan input) {

    }
}
