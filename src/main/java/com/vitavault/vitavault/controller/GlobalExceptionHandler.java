package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.exception.InvalidRequestException;
import com.vitavault.vitavault.exception.NotFoundException;
import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    @GraphQlExceptionHandler
    public GraphQLError handleGenericException(Exception ex) {
        return GraphQLError.newError()
                .message("Internal server error")
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError graphqlNotFoundExceptionHandler(NotFoundException ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError graphqlInvalidRequestExceptionHandler(InvalidRequestException ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }
}
