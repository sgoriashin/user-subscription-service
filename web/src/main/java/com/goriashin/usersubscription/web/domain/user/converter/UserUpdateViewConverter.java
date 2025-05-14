package com.goriashin.usersubscription.web.domain.user.converter;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.model.UserUpdateView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserUpdateViewConverter {

    public UserTM mutate(UserTM tm, UserUpdateView view) {
        if (view.getUsername() != null) {
            tm.setUsername(view.getUsername());
        }
        if (view.getFirstName() != null) {
            tm.setFirstName(view.getFirstName());
        }
        if (view.getLastName() != null) {
            tm.setLastName(view.getLastName());
        }
        return tm;
    }

}
