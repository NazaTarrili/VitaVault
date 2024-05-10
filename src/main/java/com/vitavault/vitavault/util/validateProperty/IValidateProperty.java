package com.vitavault.vitavault.util.validateProperty;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface IValidateProperty {
    Boolean isNonEmptyString(String str);

    Boolean isUUID(UUID id);

    Boolean isNonEmptyUUIDList(List<UUID> list);

    Boolean isNonEmptyEntityList(List<?> list);

    Boolean isInteger(Integer number);

    Boolean isDayOfWeek(DayOfWeek day);

    Boolean isLocalTime(LocalTime time);

    Boolean isLocalDate(LocalDate date);

    Boolean isLocalDateTime(LocalDateTime dateTime);

    Boolean isBoolean(Boolean bool);

    Boolean isStrongPassword(String pass);
}