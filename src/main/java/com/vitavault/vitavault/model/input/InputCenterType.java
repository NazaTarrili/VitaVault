package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputCenterType(
        String name,
        UUID subscriptionPlan
) {}
