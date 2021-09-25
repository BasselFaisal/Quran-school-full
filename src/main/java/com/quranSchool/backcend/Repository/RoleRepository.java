package com.quranSchool.backcend.Repository;

import com.quranSchool.backcend.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByName(String name);

    Optional<Role> findByName(String role_admin);
}
