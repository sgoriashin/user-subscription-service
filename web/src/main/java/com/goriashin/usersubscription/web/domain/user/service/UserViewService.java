package com.goriashin.usersubscription.web.domain.user.service;

import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;

public interface UserViewService {

    UserRefView createUser(UserCreateView view);

}
