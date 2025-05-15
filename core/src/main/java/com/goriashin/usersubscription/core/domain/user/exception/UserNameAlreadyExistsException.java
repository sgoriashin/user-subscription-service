package com.goriashin.usersubscription.core.domain.user.exception;


public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String username) {
        super("Username " + username + " already exists");
    }

}
