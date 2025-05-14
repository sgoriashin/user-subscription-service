package com.goriashin.usersubscription.web.controllers.user;

import com.goriashin.usersubscription.web.domain.user.service.UserViewService;
import com.goriashin.usersubscription.web.domain.user.model.UserCreateView;
import com.goriashin.usersubscription.web.domain.user.model.UserRefView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserViewService userViewService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserRefView createUser(@Valid @RequestBody UserCreateView body) {
        return userViewService.createUser(body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userViewService.deleteUser(id);
    }

}
