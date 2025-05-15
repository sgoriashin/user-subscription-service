package com.goriashin.usersubscription.core.domain.subscription.exception;

public class SubscriptionNotLinkedToUserException extends RuntimeException {

    public SubscriptionNotLinkedToUserException(Long subscriptionId, Long userId) {
        super("Subscription with id=" + subscriptionId + " not linked to user with id=" + userId);
    }

}
