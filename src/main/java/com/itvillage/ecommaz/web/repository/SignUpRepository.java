package com.itvillage.ecommaz.web.repository;


import com.itvillage.ecommaz.web.domain.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Long> {


    Optional<SignUp> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT id FROM SignUp user WHERE username = ?1")
    Optional<String> findAuthUsersById(String username);

    List<SignUp> findAllById(String id);
}
