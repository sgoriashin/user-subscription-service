package com.goriashin.usersubscription.web.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.service.UserViewService;
import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;
import com.goriashin.usersubscription.web.domain.user.converter.UserCreateViewConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserViewServiceImpl implements UserViewService {

    private final UserService userService;
    private final UserCreateViewConverter userCreateViewConverter;

    @Override
    public UserRefView createUser(UserCreateView view) {
        UserTM userToSave = userCreateViewConverter.toModel(view);
        UserTM savedUser = userService.createUser(userToSave);

        return UserRefView.builder()
                .id(savedUser.getId())
                .build();
    }
}
