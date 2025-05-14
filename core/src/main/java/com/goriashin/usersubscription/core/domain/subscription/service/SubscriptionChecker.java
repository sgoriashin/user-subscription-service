package com.goriashin.usersubscription.core.domain.subscription.service;


import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;

public interface SubscriptionChecker {

    void isSubscriptionLinkedToUser(SubscriptionTM subscriptionTM, UserTM userTM);

}
