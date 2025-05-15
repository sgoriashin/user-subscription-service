package com.goriashin.usersubscription.web.domain.subscription.converter;

import com.goriashin.usersubscription.core.domain.subscription.model.SubscriptionTM;
import com.goriashin.usersubscription.web.domain.subscription.model.SubscriptionLimitedView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SubscriptionLimitedViewConverter {

    public List<SubscriptionLimitedView> toView(List<SubscriptionTM> tmsList) {
        if (tmsList == null) {
            return null;
        }
        return tmsList.stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    public SubscriptionLimitedView toView(SubscriptionTM tm) {
        SubscriptionLimitedView view = new SubscriptionLimitedView();
        view.setId(tm.getId());
        view.setSubscriptionName(tm.getSubscriptionName());
        return view;
    }

}
