package com.vitavault.vitavault.service.plan;

import com.vitavault.vitavault.model.domain.Plan;
import com.vitavault.vitavault.model.input.InputPlan;
import com.vitavault.vitavault.repository.PlanRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.socialWork.ISocialWorkService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, PlanRepository> implements IPlanService {
    private final String className = Plan.class.getName();

    @Autowired
    private ISocialWorkService socialWorkService;

    @Override
    public void create(InputPlan input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("social work", input.socialWork()), className);

        repository.save(
                Plan.builder()
                        .name(input.name())
                        .socialWork(socialWorkService.getByID(input.socialWork()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputPlan input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Plan plan = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            plan.setName(input.name());

        if (validate.isUUID(input.socialWork()))
            plan.setSocialWork(socialWorkService.getByID(input.socialWork()));

        repository.save(plan);
    }
}
