package com.goriashin.usersubscription.core.domain.subscription.repository;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionTM, Long> {

}
