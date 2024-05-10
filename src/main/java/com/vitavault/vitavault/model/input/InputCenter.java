package com.vitavault.vitavault.model.input;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputCenter(
        String name,
        String phoneNumber,
        String email,
        LocalDateTime subscriptionStart,
        LocalDateTime subscriptionEnd,
        UUID address,
        UUID centerType,
        UUID billingDetail
) {}
