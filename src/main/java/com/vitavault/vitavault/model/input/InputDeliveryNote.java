package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputDeliveryNote(
        String date,
        Integer quantity,
        UUID deliveryNoteType,
        UUID supply
) {}
