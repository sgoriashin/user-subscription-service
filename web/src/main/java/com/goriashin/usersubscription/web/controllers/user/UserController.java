package com.goriashin.usersubscription.web.controllers.user;

import com.goriashin.usersubscription.web.domain.user.service.UserViewService;
import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserViewService userViewService;

    @PostMapping
    public UserRefView createUser(@Valid @RequestBody UserCreateView body) {
        return userViewService.createUser(body);
    }
}
