package com.goriashin.usersubscription.web.domain.user.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseView {
    @NotBlank(message = "{user.username.notBlank}")
    private String username;
    private String firstName;
    private String lastName;
}
