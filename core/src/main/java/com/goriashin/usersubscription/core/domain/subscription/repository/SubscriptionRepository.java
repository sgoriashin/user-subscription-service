package com.goriashin.usersubscription.core.domain.subscription.repository;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionTM, Long> {

    List<SubscriptionTM> findAllByUserId(Long userId);
    boolean existsBySubscriptionNameAndUser(String subscriptionName, UserTM userTM);

}
