package com.goriashin.usersubscription.web.domain.user.converter;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.model.UserBaseView;
import org.springframework.stereotype.Service;


@Service
public class UserBaseViewConverter {

    public void toModel(UserTM tm, UserBaseView view) {
        tm.setUsername(view.getUsername());
        tm.setFirstName(view.getFirstName());
        tm.setLastName(view.getLastName());
    }

}
