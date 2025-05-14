package com.goriashin.usersubscription.web.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.web.domain.user.converter.UserUpdateViewConverter;
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

    private final UserService userService;
    private final UserCreateViewConverter userCreateViewConverter;
    private final UserUpdateViewConverter userUpdateViewConverter;


    @Override
    public UserRefView createUser(UserCreateView view) {
        UserTM userToSave = userCreateViewConverter.toModel(view);
        UserTM savedUser = userService.createUser(userToSave);

        return UserRefView.builder()
                .id(savedUser.getId())
                .build();
    }

    @Override
    public UserRefView updateUser(Long id, UserUpdateView view) {
        UserTM sourceUser = userService.getById(id);
        UserTM updatedUser = userUpdateViewConverter.mutate(sourceUser, view);
        UserTM savedUser = userService.updateUser(updatedUser);

        return UserRefView.builder().
                id(savedUser.getId())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        UserTM userToDelete = userService.getById(id);
        userService.deleteUser(userToDelete);
    }

}
