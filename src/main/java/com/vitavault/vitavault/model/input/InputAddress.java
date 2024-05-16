package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputAddress(
        Integer number,
        String floor,
        String department,
        UUID street,
        UUID city
) implements BaseInput {
    @Override
    public boolean hasData() {
        return number != null ||
                floor != null ||
                department != null ||
                street != null ||
                city != null;
    }
}
