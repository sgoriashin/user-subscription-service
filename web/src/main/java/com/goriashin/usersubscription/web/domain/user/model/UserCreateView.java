package com.goriashin.usersubscription.web.domain.user.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCreateView extends UserBaseView{

    @NotBlank(message = "{field.required}")
    private String username;
    private LocalDateTime registrationDate;
}
