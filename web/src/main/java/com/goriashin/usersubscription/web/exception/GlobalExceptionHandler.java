package com.goriashin.usersubscription.web.exception;

import com.goriashin.usersubscription.core.domain.subscription.exception.DuplicateUserSubscriptionException;
import com.goriashin.usersubscription.core.domain.subscription.exception.SubscriptionNotLinkedToUserException;
import com.goriashin.usersubscription.core.domain.user.exception.NotFoundByIdException;
import com.goriashin.usersubscription.core.domain.user.exception.UserNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> "Field '" + e.getField() + "' is invalid: " + e.getDefaultMessage())
                .collect(Collectors.joining("; "));

        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                message
        );
    }

    @ExceptionHandler(UserNameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserNameAlreadyExistsException(UserNameAlreadyExistsException e) {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "User already exists",
                e.getMessage()
        );
    }

    @ExceptionHandler(NotFoundByIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundByIdException(NotFoundByIdException e) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Entity not found",
                e.getMessage()
        );
    }

    @ExceptionHandler(DuplicateUserSubscriptionException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse duplicateUserSubscriptionException(DuplicateUserSubscriptionException e) {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Subscription already linked to user",
                e.getMessage()
        );
    }

    @ExceptionHandler(SubscriptionNotLinkedToUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse subscriptionNotLinkedToUserException(SubscriptionNotLinkedToUserException e) {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Subscription not linked to user",
                e.getMessage()
        );
    }

}
