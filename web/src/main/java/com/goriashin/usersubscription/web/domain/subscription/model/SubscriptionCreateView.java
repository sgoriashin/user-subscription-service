package com.goriashin.usersubscription.web.domain.subscription.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SubscriptionCreateView {

    @NotBlank(message = "{field.required}")
    private String subscriptionName;

}
