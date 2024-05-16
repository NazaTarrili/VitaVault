package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputSchedule(
        UUID user,
        UUID specialty
) implements BaseInput {
    @Override
    public boolean hasData() {
        return user != null ||
                specialty != null;
    }
}
