package com.itvillage.ecommaz.web.repository;

import com.itvillage.ecommaz.web.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
