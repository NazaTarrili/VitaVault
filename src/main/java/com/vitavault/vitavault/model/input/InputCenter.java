package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

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
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                phoneNumber != null ||
                email != null ||
                subscriptionStart != null ||
                subscriptionEnd != null ||
                address != null ||
                centerType != null ||
                billingDetail != null;
    }
}
