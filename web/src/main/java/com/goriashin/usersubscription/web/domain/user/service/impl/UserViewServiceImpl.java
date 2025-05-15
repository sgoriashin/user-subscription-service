package com.goriashin.usersubscription.web.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.converter.UserFullViewConverter;
import com.goriashin.usersubscription.web.domain.user.converter.UserUpdateViewConverter;
import com.goriashin.usersubscription.web.domain.user.model.UserFullView;
import com.goriashin.usersubscription.web.domain.user.model.UserUpdateView;
import com.goriashin.usersubscription.web.domain.user.service.UserViewService;
import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;
import com.goriashin.usersubscription.web.domain.user.converter.UserCreateViewConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserViewServiceImpl implements UserViewService {

    private final UserService service;
    private final UserCreateViewConverter createViewConverter;
    private final UserUpdateViewConverter updateViewConverter;
    private final UserFullViewConverter fullViewConverter;


    @Override
    public UserFullView getUser(Long id) {
        UserTM userTM = service.getById(id);
        return fullViewConverter.toView(userTM);
    }

    @Override
    public UserRefView createUser(UserCreateView view) {
        UserTM userToSave = createViewConverter.toModel(view);
        UserTM savedUser = service.createUser(userToSave);

        return UserRefView.builder()
                .id(savedUser.getId())
                .build();
    }

    @Override
    public UserRefView updateUser(Long id, UserUpdateView view) {
        UserTM sourceUser = service.getById(id);
        UserTM updatedUser = updateViewConverter.mutate(sourceUser, view);
        UserTM savedUser = service.updateUser(updatedUser);

        return UserRefView.builder().
                id(savedUser.getId())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        UserTM userToDelete = service.getById(id);
        service.deleteUser(userToDelete);
    }

}
