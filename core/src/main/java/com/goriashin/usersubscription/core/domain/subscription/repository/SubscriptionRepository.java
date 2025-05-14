package com.goriashin.usersubscription.core.domain.subscription.repository;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionTM, Long> {

    List<SubscriptionTM> findAllByUserId(Long userId);

}
