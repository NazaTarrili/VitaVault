package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputBed(
        String name,
        UUID bedStatus,
        UUID room
) {}
