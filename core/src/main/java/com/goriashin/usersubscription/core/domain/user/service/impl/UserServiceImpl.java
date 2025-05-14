package com.goriashin.usersubscription.core.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.repository.UserRepository;
import com.goriashin.usersubscription.core.domain.user.service.UserChecker;
import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserChecker userChecker;

    @Override
    public UserTM createUser(UserTM userTM) {
        userChecker.userNameExists(userTM);
        return userRepository.saveAndFlush(userTM);
    }
}
