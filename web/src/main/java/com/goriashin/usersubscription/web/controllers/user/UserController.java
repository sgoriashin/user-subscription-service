package com.goriashin.usersubscription.web.controllers.user;

import com.goriashin.usersubscription.web.domain.user.model.UserFullView;
import com.goriashin.usersubscription.web.domain.user.model.UserUpdateView;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserFullView getUser(@PathVariable("id") Long id) {
        return userViewService.getUser(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRefView createUser(@Valid @RequestBody UserCreateView body) {
        return userViewService.createUser(body);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserRefView updateUser(@PathVariable("id") Long id,
                                  @Valid @RequestBody UserUpdateView body) {
        return userViewService.updateUser(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userViewService.deleteUser(id);
    }

}
