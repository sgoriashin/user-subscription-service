package com.goriashin.usersubscription.core.domain.user.exception;

public class NotFoundByIdException extends RuntimeException {

    public NotFoundByIdException(Long id) {
        super("Entity with id=" + id + " not found");
    }

}
