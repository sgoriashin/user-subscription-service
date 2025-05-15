package com.goriashin.usersubscription.core.domain.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDateTime registrationDate;
}
