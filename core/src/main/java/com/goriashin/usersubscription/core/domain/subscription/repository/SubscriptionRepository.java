package com.goriashin.usersubscription.core.domain.subscription.repository;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.subscription.model.TopSubscriptionDto;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionTM, Long> {

    List<SubscriptionTM> findAllByUserId(Long userId);
    boolean existsBySubscriptionNameAndUser(String subscriptionName, UserTM userTM);

    @Query("SELECT s.subscriptionName AS subscriptionName, COUNT(DISTINCT s.user.id) AS userCount " +
            "FROM SubscriptionTM s " +
            "GROUP BY s.subscriptionName " +
            "ORDER BY COUNT(s.user.id) DESC")
    List<TopSubscriptionDto> findTopSubscriptions(Pageable pageable);

}
