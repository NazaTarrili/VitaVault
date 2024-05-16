package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputCenterType(
        String name,
        UUID subscriptionPlan
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                subscriptionPlan != null;
    }
}
