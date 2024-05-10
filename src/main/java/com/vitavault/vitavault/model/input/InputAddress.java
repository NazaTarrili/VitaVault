package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputAddress(
        Integer number,
        String floor,
        String department,
        UUID street,
        UUID city
) {}
