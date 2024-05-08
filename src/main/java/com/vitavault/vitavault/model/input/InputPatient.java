package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputPatient(
        UUID person,
        UUID plan
) {}
