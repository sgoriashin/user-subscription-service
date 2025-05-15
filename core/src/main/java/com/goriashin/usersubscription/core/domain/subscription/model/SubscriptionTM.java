package com.goriashin.usersubscription.core.domain.subscription.model;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class SubscriptionTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserTM user;

    private String subscriptionName;

}
