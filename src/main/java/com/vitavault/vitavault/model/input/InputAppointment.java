package com.vitavault.vitavault.model.input;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputAppointment(
        LocalDateTime date,
        Boolean finished,
        UUID schedule,
        UUID patient
) {}
