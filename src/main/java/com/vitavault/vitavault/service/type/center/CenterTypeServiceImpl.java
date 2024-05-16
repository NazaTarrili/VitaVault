package com.vitavault.vitavault.service.type.center;

import com.vitavault.vitavault.model.domain.CenterType;
import com.vitavault.vitavault.model.input.InputCenterType;
import com.vitavault.vitavault.repository.CenterTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.subscriptionPlan.ISubscriptionPlanService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CenterTypeServiceImpl extends BaseServiceImpl<CenterType, CenterTypeRepository> implements ICenterTypeService {
    private final String className = CenterType.class.getName();

    @Autowired
    private ISubscriptionPlanService subscriptionPlanService;

    @Override
    public void create(InputCenterType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("subscription plan", input.subscriptionPlan()), className);

        repository.save(
                CenterType.builder()
                        .name(input.name())
                        .subscriptionPlan(subscriptionPlanService.getByID(input.subscriptionPlan()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputCenterType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        CenterType centerType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            centerType.setName(input.name());

        if (validate.isUUID(input.subscriptionPlan()))
            centerType.setSubscriptionPlan(subscriptionPlanService.getByID(input.subscriptionPlan()));

        repository.save(centerType);
    }
}
