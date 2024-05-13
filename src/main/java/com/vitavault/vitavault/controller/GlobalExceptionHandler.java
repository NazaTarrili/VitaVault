package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import graphql.GraphQLError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @GraphQlExceptionHandler
    public GraphQLError handleException(RuntimeException ex) {
        logger.error("Exception caught: ", ex);

        if (ex instanceof NotFoundException || ex instanceof InvalidRequestException)
            return GraphQLError.newError().message(ex.getMessage()).build();
        else
            return GraphQLError.newError().message("Internal server error:\n" + ex.getMessage()).build();
    }
}

