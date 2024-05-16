package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;
import com.vitavault.vitavault.model.types.Gender;

import java.time.LocalDateTime;
import java.util.UUID;

public record InputPerson(
        String name,
        String lastname,
        String document,
        String phoneNumber,
        String email,
        Gender gender,
        LocalDateTime birthdate,
        UUID address,
        UUID documentType
) implements BaseInput {
    @Override
    public boolean hasData() {
        return name != null ||
                lastname != null ||
                document != null ||
                phoneNumber != null ||
                email != null ||
                gender != null ||
                birthdate != null ||
                address != null ||
                documentType != null;
    }
}
