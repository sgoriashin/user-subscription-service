package com.goriashin.usersubscription.web.domain.user.service;

import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserFullView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;
import com.goriashin.usersubscription.web.domain.user.model.UserUpdateView;

public interface UserViewService {

    UserFullView getUser(Long id);
    UserRefView createUser(UserCreateView view);
    UserRefView updateUser(Long id, UserUpdateView view);
    void deleteUser(Long id);

}
