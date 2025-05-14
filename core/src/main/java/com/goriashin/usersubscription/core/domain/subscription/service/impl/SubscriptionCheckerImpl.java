package com.goriashin.usersubscription.core.domain.subscription.service.impl;

import com.goriashin.usersubscription.core.domain.subscription.exception.SubscriptionNotLinkedToUserException;
import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionChecker;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionCheckerImpl implements SubscriptionChecker {

    @Override
    public void isSubscriptionLinkedToUser(SubscriptionTM subscriptionTM, UserTM userTM) {
        if (!userTM.equals(subscriptionTM.getUser())) {
            throw new SubscriptionNotLinkedToUserException(subscriptionTM.getId(), userTM.getId());
        }
    }

}
