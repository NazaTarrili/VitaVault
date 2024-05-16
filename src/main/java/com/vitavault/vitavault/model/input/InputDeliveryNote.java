package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputDeliveryNote(
        LocalDateTime date,
        Integer quantity,
        UUID deliveryNoteType,
        UUID supply
) implements BaseInput {
    @Override
    public boolean hasData() {
        return date != null ||
                quantity != null ||
                deliveryNoteType != null ||
                supply != null;
    }
}
