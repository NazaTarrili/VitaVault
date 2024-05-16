package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record InputPeriodicity(
        DayOfWeek day,
        LocalTime start,
        LocalTime end
) implements BaseInput {
    @Override
    public boolean hasData() {
        return day != null ||
                start != null ||
                end != null;
    }
}
