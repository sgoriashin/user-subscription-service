package com.goriashin.usersubscription.core.domain.subscription.service.impl;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.repository.SubscriptionRepository;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionChecker;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionService;
import com.goriashin.usersubscription.core.domain.user.exception.NotFoundByIdException;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final SubscriptionChecker checker;

    @Override
    public SubscriptionTM getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundByIdException(id));
    }

    @Override
    public List<SubscriptionTM> getByUser(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public SubscriptionTM createSubscription(SubscriptionTM subscriptionTM) {
        return repository.saveAndFlush(subscriptionTM);
    }

    @Override
    public void deleteSubscription(UserTM userTM, SubscriptionTM subscriptionTM) {
        checker.isSubscriptionLinkedToUser(subscriptionTM, userTM);
        repository.delete(subscriptionTM);
    }

}
