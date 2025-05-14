package com.goriashin.usersubscription.core.domain.subscription.service;


import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;

public interface SubscriptionService {

    SubscriptionTM getById(Long id);
    SubscriptionTM createSubscription(SubscriptionTM subscriptionTM);
    void deleteSubscription(UserTM userTM, SubscriptionTM subscriptionTM);

}
