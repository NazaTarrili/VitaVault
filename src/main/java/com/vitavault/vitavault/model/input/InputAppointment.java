package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputAppointment(
        LocalDateTime date,
        Boolean finished,
        UUID schedule,
        UUID patient
) implements BaseInput {
    @Override
    public boolean hasData() {
        return date != null ||
                finished != null ||
                schedule != null ||
                patient != null;
    }
}
