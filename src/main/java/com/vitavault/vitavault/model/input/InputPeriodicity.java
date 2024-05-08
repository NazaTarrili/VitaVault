package com.vitavault.vitavault.model.input;

import java.time.DayOfWeek;

public record InputPeriodicity(
        DayOfWeek day,
        String start,
        String end
) {}
