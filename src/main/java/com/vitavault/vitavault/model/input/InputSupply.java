package com.vitavault.vitavault.model.input;

import java.util.List;
import java.util.UUID;

public record InputSupply(
        String name,
        Integer stock,
        String dueDate,
        Integer minimalStock,
        List<UUID> suppliers,
        UUID supplyType
) {}
