package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputBed(
        String name,
        UUID bedStatus,
        UUID room
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                bedStatus != null ||
                room != null;
    }
}
