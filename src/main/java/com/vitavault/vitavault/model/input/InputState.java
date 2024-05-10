package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputState(
        String name,
        UUID country
) {
}
