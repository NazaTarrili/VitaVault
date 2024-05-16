package com.vitavault.vitavault.util.validateProperty;

import com.vitavault.vitavault.model.types.Gender;
import com.vitavault.vitavault.model.types.Password;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IValidateProperty {
    Boolean isNonEmptyString(String str);

    Boolean isUUID(UUID id);

    Boolean isNonEmptyUUIDList(List<UUID> list);

    Boolean isNonEmptyUUIDSet(Set<UUID> list);

    Boolean isNonEmptyEntityList(List<?> list);

    Boolean isInteger(Integer number);

    Boolean isDayOfWeek(DayOfWeek day);

    Boolean isGender(Gender gender);

    Boolean isLocalTime(LocalTime time);

    Boolean isLocalDate(LocalDate date);

    Boolean isLocalDateTime(LocalDateTime dateTime);

    Boolean isBoolean(Boolean bool);

    Boolean isFloat(Float fl);

    Boolean isStrongPassword(Password pass);
}