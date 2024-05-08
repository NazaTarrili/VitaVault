package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputDeliveryNote(
        String date,
        int quantity,
        UUID deliveryNoteType,
        UUID supply
) {}
