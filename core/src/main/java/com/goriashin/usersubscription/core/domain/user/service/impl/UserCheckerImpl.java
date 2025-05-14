package com.goriashin.usersubscription.core.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.exception.UserNameAlreadyExistsException;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import com.goriashin.usersubscription.core.domain.user.repository.UserRepository;
import com.goriashin.usersubscription.core.domain.user.service.UserChecker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserCheckerImpl implements UserChecker {

    private final UserRepository userRepository;

    @Override
    public void userNameExists(UserTM userTM) {
        if (userRepository.existsByUsername(userTM.getUsername())) {
            log.info("Username {} already exists", userTM.getUsername());
            throw new UserNameAlreadyExistsException(userTM.getUsername());
        }
    }

}
