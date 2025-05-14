package com.goriashin.usersubscription.web.domain.subscription.converter;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionCreateView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SubscriptionCreateViewConverter {

    public SubscriptionTM toModel(UserTM userTM, SubscriptionCreateView view) {
        SubscriptionTM tm = new SubscriptionTM();
        tm.setUser(userTM);
        tm.setSubscriptionName(view.getSubscriptionName());
        return tm;
    }

}
