package com.vitavault.vitavault.model.input;

import java.util.UUID;

public record InputAppointment(
        String date,
        boolean finished,
        UUID schedule,
        UUID patient
) {}
