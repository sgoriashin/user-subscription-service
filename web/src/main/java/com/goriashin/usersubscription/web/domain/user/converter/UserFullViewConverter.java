package com.goriashin.usersubscription.web.domain.user.converter;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.model.UserFullView;
import org.springframework.stereotype.Service;


@Service
public class UserFullViewConverter {

    public UserFullView toView(UserTM tm) {
        UserFullView view = new UserFullView();
        view.setId(tm.getId());
        view.setUsername(tm.getUsername());
        view.setFirstName(tm.getFirstName());
        view.setLastName(tm.getLastName());
        view.setRegistrationDate(tm.getRegistrationDate());
        return view;
    }

}
