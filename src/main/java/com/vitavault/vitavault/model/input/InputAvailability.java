package com.vitavault.vitavault.model.input;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record InputAvailability(
        LocalDate day,
        LocalTime start,
        LocalTime end,
        UUID schedule
) {}
