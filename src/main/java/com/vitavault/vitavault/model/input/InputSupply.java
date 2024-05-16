package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record InputSupply(
        String name,
        Integer stock,
        LocalDateTime dueDate,
        Integer minimalStock,
        Set<UUID> suppliers,
        UUID supplyType
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                stock != null ||
                dueDate != null ||
                minimalStock != null ||
                suppliers != null ||
                supplyType != null;
    }
}
