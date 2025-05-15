package com.goriashin.usersubscription.core.domain.subscription.exception;

public class DuplicateUserSubscriptionException extends RuntimeException {

    public DuplicateUserSubscriptionException(String subscriptionName, Long userId) {
        super("User with id " + userId + " already exists in subscription " + subscriptionName);
    }

}
