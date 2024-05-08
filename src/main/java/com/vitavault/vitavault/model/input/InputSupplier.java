package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputSupplier(
        String name,
        UUID address
) {}
