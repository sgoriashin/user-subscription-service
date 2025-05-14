package com.goriashin.usersubscription.web.domain.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCreateView extends UserBaseView{
    private LocalDateTime registrationDate;
}
