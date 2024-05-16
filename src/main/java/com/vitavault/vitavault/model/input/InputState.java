package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputState(
        String name,
        UUID country
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                country != null;
    }
}
