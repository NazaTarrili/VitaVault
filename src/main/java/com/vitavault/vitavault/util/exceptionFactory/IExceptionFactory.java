package com.vitavault.vitavault.util.exceptionFactory;

import com.vitavault.vitavault.exception.NotFoundException;

public interface IExceptionFactory {
    //throw methods
    void throwInvalidRequest(String className, String propertyName);

    void throwNotFound();

    void throwEmptyList(String className, String propertyName);

    void throwEmptyList();

    void throwInvalidList(String className, String propertyName);

    void throwInvalidInput(String className);

    void throwWeakPassword(String className);

    //return new methods
    NotFoundException newNotFound(String className);

    NotFoundException newNotFound();
}
