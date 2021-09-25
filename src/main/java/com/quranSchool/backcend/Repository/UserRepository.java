package com.quranSchool.backcend.Repository;

import com.quranSchool.backcend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.mobile = :email or u.email = :email")
//    Optional<User> findByMobileOrEmail(@Param("email") String email);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
