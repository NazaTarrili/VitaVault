package com.vitavault.vitavault.service.plan;

import com.vitavault.vitavault.model.domain.Plan;
import com.vitavault.vitavault.model.input.InputPlan;
import com.vitavault.vitavault.repository.PlanRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, PlanRepository> implements IPlanService {
    @Override
    public void create(InputPlan input) {

    }

    @Override
    public void update(UUID id, InputPlan input) {

    }
}
