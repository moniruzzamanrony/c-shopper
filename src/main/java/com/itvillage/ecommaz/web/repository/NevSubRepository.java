package com.itvillage.ecommaz.web.repository;

import com.itvillage.ecommaz.web.domain.NevSubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NevSubRepository extends JpaRepository<NevSubItem, String> {

}
