package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputCenter(
        String name,
        String phoneNumber,
        String email,
        String subscriptionStart,
        String subscriptionEnd,
        UUID address,
        UUID subscriptionStatus,
        UUID centerType,
        UUID billingDetail
) {}
