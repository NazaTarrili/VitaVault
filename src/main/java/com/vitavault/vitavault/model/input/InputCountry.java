package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

public record InputCountry(String name) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null;
    }
}
