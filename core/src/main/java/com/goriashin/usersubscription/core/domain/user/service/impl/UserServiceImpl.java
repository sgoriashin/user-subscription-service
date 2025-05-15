package com.goriashin.usersubscription.core.domain.user.service.impl;

import com.goriashin.usersubscription.core.domain.user.exception.NotFoundByIdException;
import com.goriashin.usersubscription.core.domain.user.repository.UserRepository;
import com.goriashin.usersubscription.core.domain.user.service.UserChecker;
import com.goriashin.usersubscription.core.domain.user.service.UserService;
import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserChecker userChecker;

    @Override
    public UserTM getById(Long id) {
        log.info("Getting user by id: {}", id);
        UserTM userTM =  userRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(id));
        log.info("User found with id: {}", userTM.getId());
        return userTM;
    }

    @Override
    public UserTM createUser(UserTM userTM) {
        userChecker.userNameExists(userTM);

        log.info("Creating user with username: {}", userTM.getUsername());
        UserTM createdUser = userRepository.saveAndFlush(userTM);
        log.info("User {} created with id: {}", createdUser.getUsername(), createdUser.getId());
        return createdUser;
    }

    @Override
    public UserTM updateUser(UserTM userTM) {
        log.info("Updating user with id: {}", userTM.getId());
        UserTM updatedUser =  userRepository.saveAndFlush(userTM);
        log.info("Updated user with id: {}", updatedUser.getId());
        return updatedUser;
    }

    @Override
    public void deleteUser(UserTM userTM) {
        log.info("Deleting user with id: {}", userTM.getId());
        userRepository.delete(userTM);
        log.info("Deleted user with id: {}", userTM.getId());
    }

}
