package com.vitavault.vitavault.util.validateProperty;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class ValidateProperty implements IValidateProperty {
    public Boolean isNonEmptyString(String str) {
        return str != null && !str.isBlank();
    }

    public Boolean isUUID(UUID id) {
        return id != null;
    }

    public Boolean isNonEmptyUUIDList(List<UUID> list) {
        return list != null && !list.isEmpty() && list.stream().allMatch(Objects::nonNull);
    }

    public Boolean isNonEmptyEntityList(List<?> list) {
        return list != null && !list.isEmpty();
    }

    public Boolean isInteger(Integer number) {
        return number != null;
    }

    public Boolean isDayOfWeek(DayOfWeek day) {
        return day != null;
    }

    public Boolean isLocalTime(LocalTime time) {
        return time != null;
    }

    public Boolean isLocalDate(LocalDate date) {
        return date != null;
    }

    public Boolean isLocalDateTime(LocalDateTime dateTime) {
        return dateTime != null;
    }

    public Boolean isBoolean(Boolean bool) {
        return bool != null;
    }

    public Boolean isStrongPassword(String pass) {
        return pass != null &&
                pass.length() >= 8 &&
                pass.matches(".*[A-Z].*") &&
                pass.matches(".*[a-z].*") &&
                pass.matches(".*\\d.*");
    }
}
