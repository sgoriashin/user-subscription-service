package com.goriashin.usersubscription.web.domain.subscription.service.impl;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.web.domain.subscription.converter.SubscriptionCreateViewConverter;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionCreateView;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionRefView;
import com.goriashin.usersubscription.web.domain.subscription.service.SubscriptionViewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionViewServiceImpl implements SubscriptionViewService {

    private final SubscriptionService subscriptionService;
    private final UserService userService;
    private final SubscriptionCreateViewConverter createViewConverter;

    @Override
    public SubscriptionRefView createSubscription(Long userId, SubscriptionCreateView view) {
        UserTM user = userService.getById(userId);
        SubscriptionTM subscription = createViewConverter.toModel(user, view);
        SubscriptionTM savedSubscription = subscriptionService.createSubscription(subscription);

        return SubscriptionRefView.builder()
                .id(savedSubscription.getId())
                .build();
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        UserTM user = userService.getById(userId);
        SubscriptionTM subscriptionTM = subscriptionService.getById(subscriptionId);
        subscriptionService.deleteSubscription(user, subscriptionTM);
    }
}
