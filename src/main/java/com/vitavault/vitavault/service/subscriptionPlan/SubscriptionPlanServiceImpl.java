package com.vitavault.vitavault.service.subscriptionPlan;

import com.vitavault.vitavault.model.domain.SubscriptionPlan;
import com.vitavault.vitavault.model.input.InputSubscriptionPlan;
import com.vitavault.vitavault.repository.SubscriptionPlanRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.periodicity.IPeriodicityService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SubscriptionPlanServiceImpl extends BaseServiceImpl<SubscriptionPlan, SubscriptionPlanRepository> implements ISubscriptionPlanService {
    private final String className = SubscriptionPlan.class.getName();

    @Autowired
    private IPeriodicityService periodicityService;

    @Override
    public void create(InputSubscriptionPlan input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("cost", input.cost()), className);
        requestValidator.invalidRequest(new Property("terms", input.terms()), className);
        requestValidator.invalidRequest(new Property("periodicity", input.periodicity()), className);

        repository.save(
                SubscriptionPlan.builder()
                        .name(input.name())
                        .cost(input.cost())
                        .terms(input.terms())
                        .periodicity(periodicityService.getByID(input.periodicity()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputSubscriptionPlan input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        SubscriptionPlan subscriptionPlan = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            subscriptionPlan.setName(input.name());

        if (validate.isFloat(input.cost()))
            subscriptionPlan.setCost(input.cost());

        if (validate.isNonEmptyString(input.terms()))
            subscriptionPlan.setTerms(input.terms());

        if (validate.isUUID(input.periodicity()))
            subscriptionPlan.setPeriodicity(periodicityService.getByID(input.periodicity()));

        repository.save(subscriptionPlan);
    }
}
