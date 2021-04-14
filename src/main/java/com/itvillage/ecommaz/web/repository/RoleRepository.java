package com.itvillage.ecommaz.web.repository;


import com.itvillage.ecommaz.web.domain.Role;
import com.itvillage.ecommaz.web.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Optional<Role> findByName(RoleName roleName);
    Optional<Role> findByName(RoleName role);

}
