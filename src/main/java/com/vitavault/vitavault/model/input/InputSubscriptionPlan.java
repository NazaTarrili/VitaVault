package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputSubscriptionPlan(
        String name,
        Float cost,
        String terms,
        UUID periodicity
) {
}
