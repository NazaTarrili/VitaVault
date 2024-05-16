package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputCity(
        String name,
        UUID state
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                state != null;
    }
}
