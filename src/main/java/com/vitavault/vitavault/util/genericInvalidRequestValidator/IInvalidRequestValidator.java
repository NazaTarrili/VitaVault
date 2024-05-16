package com.vitavault.vitavault.util.genericInvalidRequestValidator;

import com.vitavault.vitavault.util.exceptionFactory.Property;

public interface IInvalidRequestValidator {
    void invalidRequest(Property property, String className);
}
