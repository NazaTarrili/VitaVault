package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputPatient(
        UUID person,
        UUID plan
) implements BaseInput {
    @Override
    public boolean hasData() {
        return person != null ||
                plan != null;
    }
}
