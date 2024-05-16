package com.vitavault.vitavault.util.exceptionFactory;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactory implements IExceptionFactory {
    //throw methods
    @Override
    public void throwInvalidRequest(String className, String propertyName) {
        throw new InvalidRequestException(className + ": " + propertyName + " is required.");
    }

    @Override
    public void throwNotFound() {
        throw new NotFoundException("Not exists an entity with this ID.");
    }

    @Override
    public void throwEmptyList(String className, String propertyName) {
        throw new NotFoundException(className + ": " + propertyName + "list is empty.");
    }

    @Override
    public void throwEmptyList() {
        throw new NotFoundException("List is empty.");
    }

    @Override
    public void throwInvalidList(String className, String propertyName) {
        throw new InvalidRequestException(className + ": list contains non " + propertyName + " elements.");
    }

    @Override
    public void throwInvalidInput(String className) {
        throw new InvalidRequestException("Input " + className + " is empty.");
    }

    @Override
    public void throwWeakPassword(String className) {
        throw new InvalidRequestException(className + ": weak password. Please, minimal 8 characters, 1 number and 1 uppercase character");
    }

    //return new methods
    @Override
    public NotFoundException newNotFound(String className) {
        return new NotFoundException(className + ": not found entity.");
    }

    @Override
    public NotFoundException newNotFound() {
        return new NotFoundException("Not found entity.");
    }
}
