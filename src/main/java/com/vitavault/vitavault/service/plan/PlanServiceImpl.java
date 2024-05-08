package com.vitavault.vitavault.service.plan;

import com.vitavault.vitavault.model.domain.Plan;
import com.vitavault.vitavault.repository.PlanRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, PlanRepository> implements IPlanService {
}
