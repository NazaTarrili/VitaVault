package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputSocialWork(
        String name,
        UUID address
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                address != null;
    }
}
