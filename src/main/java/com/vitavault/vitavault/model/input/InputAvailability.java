package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record InputAvailability(
        LocalDate day,
        LocalTime start,
        LocalTime end,
        UUID schedule
) implements BaseInput {
    @Override
    public boolean hasData() {
        return day != null ||
                start != null ||
                end != null ||
                schedule != null;
    }
}
