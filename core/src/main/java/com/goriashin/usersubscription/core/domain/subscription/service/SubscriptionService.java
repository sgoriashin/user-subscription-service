package com.goriashin.usersubscription.core.domain.subscription.service;


import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;

import java.util.List;

public interface SubscriptionService {

    SubscriptionTM getById(Long id);
    List<SubscriptionTM> getByUser(Long userId);
    SubscriptionTM createSubscription(SubscriptionTM subscriptionTM);
    void deleteSubscription(UserTM userTM, SubscriptionTM subscriptionTM);

}
