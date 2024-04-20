package com.vitavault.vitavault.util;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public class ValidateProperties {
    public Boolean stringCase (String str) {
        return str != null && !str.isBlank();
    }

    public Boolean idCase (Integer id) {
        return id != null && id > 0;
    }

    public Boolean idListCase (List<Integer> list) {
        return list != null && !list.isEmpty();
    }

    public Boolean entityList (List<?> list) {
        return !list.isEmpty();
    }

    public Boolean dtoList (List<?> list) {
        return list.isEmpty();
    }

    public Boolean intCase (Integer number) {
        return number != null;
    }

    public Boolean dateCase (Date date) {
        return date != null;
    }

    public Boolean dayWeekCase (DayOfWeek day) {
        return day != null;
    }

    public Boolean localTimeCase (LocalTime time) {
        return time != null;
    }

    public Boolean localDateCase (LocalDate date) {
        return date != null;
    }

    public Boolean boolCase (Boolean bool) {
        return bool != null;
    }

    public boolean isStrongPassword(String pass) {
        return pass.length() >= 8 &&
                pass.matches(".*[A-Z].*") &&
                pass.matches(".*[a-z].*") &&
                pass.matches(".*\\d.*");
    }
}
