package com.goriashin.usersubscription.web.domain.user.converter;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@AllArgsConstructor
public class UserCreateViewConverter {

    private final UserBaseViewConverter userBaseViewConverter;

    public UserTM toModel(UserCreateView view) {
        UserTM tm = new UserTM();
        userBaseViewConverter.toModel(tm, view);
        tm.setRegistrationDate(LocalDateTime.now(ZoneOffset.UTC));
        return tm;
    }

}
