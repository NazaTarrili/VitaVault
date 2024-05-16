package com.vitavault.vitavault.util.validateProperty;

import com.vitavault.vitavault.model.types.Gender;
import com.vitavault.vitavault.model.types.Password;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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

    @Override
    public Boolean isNonEmptyUUIDSet(Set<UUID> list) {
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

    public Boolean isGender(Gender gender) {
        return gender != null;
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

    @Override
    public Boolean isFloat(Float fl) {
        return fl != null && !fl.isInfinite() && !fl.isNaN();
    }

    public Boolean isStrongPassword(Password pass) {
        return pass.getPassword() != null &&
                pass.getPassword().length() >= 8 &&
                pass.getPassword().matches(".*[A-Z].*") &&
                pass.getPassword().matches(".*[a-z].*") &&
                pass.getPassword().matches(".*\\d.*");
    }
}
