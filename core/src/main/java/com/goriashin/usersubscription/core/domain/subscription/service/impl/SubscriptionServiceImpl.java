package com.goriashin.usersubscription.core.domain.subscription.service.impl;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.model.TopSubscriptionDto;
import com.goriashin.usersubscription.core.domain.subscription.repository.SubscriptionRepository;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionChecker;
import com.goriashin.usersubscription.core.domain.subscription.service.SubscriptionService;
import com.goriashin.usersubscription.core.domain.user.exception.NotFoundByIdException;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final SubscriptionChecker checker;

    @Override
    public SubscriptionTM getById(Long id) {
        log.info("Getting subscription by id: {}", id);
        SubscriptionTM subscriptionTM = repository.findById(id).orElseThrow(() -> new NotFoundByIdException(id));
        log.info("Found subscription with id: {}", subscriptionTM.getId());
        return subscriptionTM;
    }

    @Override
    public List<TopSubscriptionDto> getTopSubscriptions(Pageable pageable) {
        log.info("Getting top-{} subscriptions", pageable.getPageSize());
        List<TopSubscriptionDto> topSubscriptions = repository.findTopSubscriptions(pageable);
        log.info("Found {} top subscriptions", topSubscriptions.size());
        return topSubscriptions;
    }

    @Override
    public List<SubscriptionTM> getByUser(Long userId) {
        log.info("Getting subscriptions by user: {}", userId);
        List<SubscriptionTM> subscriptionTMList = repository.findAllByUserId(userId);
        log.info("Found {} subscriptions", subscriptionTMList.size());
        return subscriptionTMList;
    }

    @Override
    public SubscriptionTM createSubscription(SubscriptionTM subscriptionTM) {
        checker.duplicateUserSubscription(subscriptionTM);

        log.info("Creating subscription: {} for user with id: {}", subscriptionTM.getSubscriptionName(), subscriptionTM.getUser().getId());
        SubscriptionTM subscription = repository.saveAndFlush(subscriptionTM);
        log.info("Created subscription with id: {}", subscription.getId());
        return subscription;
    }

    @Override
    public void deleteSubscription(UserTM userTM, SubscriptionTM subscriptionTM) {
        checker.isSubscriptionLinkedToUser(subscriptionTM, userTM);
        log.info("Deleting subscription with id: {}", subscriptionTM.getId());
        repository.delete(subscriptionTM);
        log.info("Deleted subscription with id: {}", subscriptionTM.getId());
    }

}
