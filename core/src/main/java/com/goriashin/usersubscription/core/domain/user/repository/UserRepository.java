package com.goriashin.usersubscription.core.domain.user.repository;

import com.goriashin.usersubscription.core.domain.user.model.UserTM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTM, Long> {
}
