package com.goriashin.usersubscription.web.domain.subscription.service;

import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionCreateView;
import com.goriashin.usersubscription.web.domain.subscription.model.TopSubscriptionView;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionLimitedView;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionRefView;

import java.util.List;

public interface SubscriptionViewService {

    List<SubscriptionLimitedView> getSubscriptionsByUser(Long userId);
    List<TopSubscriptionView> getTopSubscriptions();
    SubscriptionRefView createSubscription(Long userId, SubscriptionCreateView view);
    void deleteSubscription(Long userId, Long subscriptionId);

}
