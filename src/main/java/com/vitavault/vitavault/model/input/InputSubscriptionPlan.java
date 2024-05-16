package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputSubscriptionPlan(
        String name,
        Float cost,
        String terms,
        UUID periodicity
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                cost != null ||
                terms != null ||
                periodicity != null;
    }
}
