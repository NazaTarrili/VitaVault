package com.sigis.sigis.service.plan;

import com.sigis.sigis.domain.Plan;
import com.sigis.sigis.repository.PlanRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, PlanRepository> implements IPlanService {
}
