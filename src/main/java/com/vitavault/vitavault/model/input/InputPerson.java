package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.enums.Gender;

import java.util.UUID;

public record InputPerson(
        String name,
        String lastname,
        String document,
        String phoneNumber,
        String email,
        Gender gender,
        String birthdate,
        UUID address,
        UUID documentType
) {}
