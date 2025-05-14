package com.goriashin.usersubscription.core.domain.user.service;


import com.goriashin.usersubscription.core.domain.user.model.UserTM;

public interface UserChecker {

    void userNameExists(UserTM userTM);

}
