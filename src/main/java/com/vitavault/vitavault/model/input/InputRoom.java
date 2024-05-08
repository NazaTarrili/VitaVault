package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputRoom(
        String name,
        UUID roomType,
        UUID center
) {}
