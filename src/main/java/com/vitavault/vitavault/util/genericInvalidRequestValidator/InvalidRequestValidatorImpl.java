package com.vitavault.vitavault.util.genericInvalidRequestValidator;

import com.vitavault.vitavault.model.types.Password;
import com.vitavault.vitavault.util.exceptionFactory.IExceptionFactory;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Component
public class InvalidRequestValidatorImpl implements IInvalidRequestValidator {
    @Autowired
    private IValidateProperty validate;

    @Autowired
    private IExceptionFactory exceptionFactory;

    @Override
    public void invalidRequest(Property property, String className) {
        Object value = property.value();
        String propertyName = property.name();

        switch (getType(value)) {
            case STRING:
                validateString((String) value, className, propertyName);
                break;
            case UUID:
                validateUUID((UUID) value, className, propertyName);
                break;
            case LIST_UUID:
                validateListUUID((List<UUID>) value, className, propertyName);
                break;
            case INTEGER:
                validateInteger((Integer) value, className, propertyName);
                break;
            case DAY_OF_WEEK:
                validateDayOfWeek((DayOfWeek) value, className, propertyName);
                break;
            case LOCAL_TIME:
                validateLocalTime((LocalTime) value, className, propertyName);
                break;
            case LOCAL_DATE:
                validateLocalDate((LocalDate) value, className, propertyName);
                break;
            case LOCAL_DATE_TIME:
                validateLocalDateTime((LocalDateTime) value, className, propertyName);
                break;
            case BOOLEAN:
                validateBoolean((Boolean) value, className, propertyName);
                break;
            case FLOAT:
                validateFloat((Float) value, className, propertyName);
                break;
            case PASSWORD:
                validatePassword((Password) value, className);
                break;
            default:
                break;
        }
    }

    private TypesForValidate getType(Object value) {
        if (value instanceof String)
            return TypesForValidate.STRING;

        if (value instanceof UUID)
            return TypesForValidate.UUID;

        if (value instanceof List<?>) {
            if (((List<?>) value).isEmpty())
                return TypesForValidate.EMPTY_LIST;

            if (((List<?>) value).getFirst() instanceof UUID)
                return TypesForValidate.LIST_UUID;
        }

        if (value instanceof Integer)
            return TypesForValidate.INTEGER;

        if (value instanceof DayOfWeek)
            return TypesForValidate.DAY_OF_WEEK;

        if (value instanceof LocalTime)
            return TypesForValidate.LOCAL_TIME;

        if (value instanceof LocalDate)
            return TypesForValidate.LOCAL_DATE;

        if (value instanceof LocalDateTime)
            return TypesForValidate.LOCAL_DATE_TIME;

        if (value instanceof Boolean)
            return TypesForValidate.BOOLEAN;

        if (value instanceof Float)
            return TypesForValidate.FLOAT;

        if (value instanceof Password)
            return TypesForValidate.PASSWORD;

        return TypesForValidate.UNSUPPORTED;
    }

    private void validateString(String value, String className, String propertyName) {
        if (!validate.isNonEmptyString(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateUUID(UUID value, String className, String propertyName) {
        if (!validate.isUUID(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateListUUID(List<UUID> value, String className, String propertyName) {
        if (value.isEmpty())
            exceptionFactory.throwEmptyList(className, propertyName);
        else {
            for (UUID item : value) {
                if (!validate.isUUID(item)) {
                    exceptionFactory.throwInvalidList(className, propertyName);
                    break;
                }
            }
        }
    }

    private void validateInteger(Integer value, String className, String propertyName) {
        if (!validate.isInteger(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateDayOfWeek(DayOfWeek value, String className, String propertyName) {
        if (!validate.isDayOfWeek(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateLocalTime(LocalTime value, String className, String propertyName) {
        if (!validate.isLocalTime(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateLocalDate(LocalDate value, String className, String propertyName) {
        if (!validate.isLocalDate(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateLocalDateTime(LocalDateTime value, String className, String propertyName) {
        if (!validate.isLocalDateTime(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateBoolean(Boolean value, String className, String propertyName) {
        if (!validate.isBoolean(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validateFloat(Float value, String className, String propertyName) {
        if (!validate.isFloat(value))
            throwInvalidProperty(className, propertyName);
    }

    private void validatePassword(Password password, String className) {
        if (!validate.isStrongPassword(password))
            exceptionFactory.throwWeakPassword(className);
    }

    private void throwInvalidProperty(String className, String propertyName) {
        exceptionFactory.throwInvalidRequest(className, propertyName);
    }
}