package com.goriashin.usersubscription.core.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.exception.UserNameAlreadyExistsException;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.core.domain.user.repository.UserRepository;
import com.goriashin.usersubscription.core.domain.user.service.UserChecker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCheckerImpl implements UserChecker {

    private final UserRepository userRepository;

    @Override
    public void userNameExists(UserTM userTM) {
        if (userRepository.existsByUsername(userTM.getUsername())) {
            throw new UserNameAlreadyExistsException(userTM.getUsername());
        }
    }

}
