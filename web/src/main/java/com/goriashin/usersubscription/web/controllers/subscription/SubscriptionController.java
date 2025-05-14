package com.goriashin.usersubscription.web.controllers.subscription;

import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionCreateView;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionRefView;
import com.goriashin.usersubscription.web.domain.subscription.service.SubscriptionViewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionViewService viewService;

    @PostMapping(path = "/users/{id}/subscriptions")
    @ResponseStatus(HttpStatus.CREATED)
    public SubscriptionRefView createSubscription(@PathVariable("id") Long id,
                                                  @RequestBody @Valid SubscriptionCreateView body) {
        return viewService.createSubscription(id, body);
    }

    @DeleteMapping(path = "/users/{userId}/subscriptions/{subscriptionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscription(@PathVariable("userId") Long userId,
                                   @PathVariable("subscriptionId") Long subscriptionId) {
        viewService.deleteSubscription(userId, subscriptionId);
    }

}
