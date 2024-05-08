package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputUser(
        String password,
        boolean active,
        UUID center,
        UUID person,
        UUID role
) {}
