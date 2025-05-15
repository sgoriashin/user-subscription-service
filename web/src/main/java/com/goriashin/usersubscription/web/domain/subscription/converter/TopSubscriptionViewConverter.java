package com.goriashin.usersubscription.web.domain.subscription.converter;

import com.goriashin.usersubscription.core.domain.subscription.model.TopSubscriptionDto;
import com.goriashin.usersubscription.web.domain.subscription.model.TopSubscriptionView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TopSubscriptionViewConverter {

    public List<TopSubscriptionView> toView(List<TopSubscriptionDto> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    public TopSubscriptionView toView(TopSubscriptionDto dto) {
        TopSubscriptionView view = new TopSubscriptionView();
        view.setSubscriptionName(dto.getSubscriptionName());
        view.setUserCount(dto.getUserCount());
        return view;
    }

}
