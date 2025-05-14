package com.goriashin.usersubscription.core.domain.user.service;


import com.goriashin.usersubscription.core.domain.user.model.UserTM;

public interface UserService {

    UserTM getById(Long id);
    UserTM createUser(UserTM userTM);
    void deleteUser(UserTM userTM);

}
