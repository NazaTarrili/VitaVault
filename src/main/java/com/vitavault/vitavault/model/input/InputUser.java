package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputUser(
        String password,
        Boolean active,
        UUID center,
        UUID person,
        UUID role
) {}
