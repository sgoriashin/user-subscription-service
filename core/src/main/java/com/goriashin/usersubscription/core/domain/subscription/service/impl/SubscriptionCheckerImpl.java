package com.goriashin.usersubscription.core.domain.subscription.service.impl;

import com.goriashin.usersubscription.core.domain.subscription.exception.DuplicateUserSubscriptionException;
import com.goriashin.usersubscription.core.domain.subscription.exception.SubscriptionNotLinkedToUserException;
import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.repository.SubscriptionRepository;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionChecker;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubscriptionCheckerImpl implements SubscriptionChecker {

    private final SubscriptionRepository repository;

    @Override
    public void duplicateUserSubscription(SubscriptionTM subscriptionTM) {
        String subscriptionName = subscriptionTM.getSubscriptionName();
        UserTM userTM = subscriptionTM.getUser();
        if (repository.existsBySubscriptionNameAndUser(subscriptionName, userTM)) {
            log.info("Subscription with name {} already exists for user with id: {}", subscriptionName, userTM.getId());
            throw new DuplicateUserSubscriptionException(subscriptionName, userTM.getId());
        }
    }

    @Override
    public void isSubscriptionLinkedToUser(SubscriptionTM subscriptionTM, UserTM userTM) {
        if (!userTM.equals(subscriptionTM.getUser())) {
            log.info("Subscription with name {} is not linked to user with id: {}",
                    subscriptionTM.getSubscriptionName(), userTM.getId());
            throw new SubscriptionNotLinkedToUserException(subscriptionTM.getId(), userTM.getId());
        }
    }

}
