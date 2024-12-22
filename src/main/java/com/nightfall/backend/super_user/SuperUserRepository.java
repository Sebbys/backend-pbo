package com.nightfall.backend.super_user;
import com.nightfall.backend.super_user.SuperUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperUserRepository extends JpaRepository<SuperUser, String> {
}
