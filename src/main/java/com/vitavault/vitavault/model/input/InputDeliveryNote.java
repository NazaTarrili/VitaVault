package com.vitavault.vitavault.model.input;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputDeliveryNote(
        LocalDateTime date,
        Integer quantity,
        UUID deliveryNoteType,
        UUID supply
) {}
