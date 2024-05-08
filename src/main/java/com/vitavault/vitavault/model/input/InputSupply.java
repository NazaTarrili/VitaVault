package com.vitavault.vitavault.model.input;

import java.util.List;
import java.util.UUID;

public record InputSupply(
        String name,
        int stock,
        String dueDate,
        int minimalStock,
        List<UUID> suppliers,
        UUID supplyType
) {}
