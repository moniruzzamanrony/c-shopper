package com.itvillage.cshopper.repository;



import com.itvillage.cshopper.domain.Role;
import com.itvillage.cshopper.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Optional<Role> findByName(RoleName roleName);
    Optional<Role> findByName(RoleName role);

}
