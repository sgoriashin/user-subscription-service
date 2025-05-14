package com.goriashin.usersubscription.web.domain.subscription.service;

import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionCreateView;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionRefView;

public interface SubscriptionViewService {

    SubscriptionRefView createSubscription(Long userId, SubscriptionCreateView view);
    void deleteSubscription(Long userId, Long subscriptionId);

}
