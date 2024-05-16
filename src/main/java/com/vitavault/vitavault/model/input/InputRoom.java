package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputRoom(
        String name,
        UUID roomType,
        UUID center
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                roomType != null ||
                center != null;
    }
}
