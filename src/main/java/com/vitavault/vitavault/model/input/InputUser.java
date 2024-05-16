package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;
import com.vitavault.vitavault.model.types.Password;

import java.util.UUID;

public record InputUser(
        Password password,
        Boolean active,
        UUID center,
        UUID person,
        UUID role
) implements BaseInput {
    @Override
    public boolean hasData() {
        return password.getPassword() != null ||
                active != null ||
                center != null ||
                person != null ||
                role != null;
    }
}
