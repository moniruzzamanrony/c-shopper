package com.itvillage.ecommaz.web.repository;

import com.itvillage.ecommaz.web.domain.NevItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NevRepository extends JpaRepository<NevItem, String> {

}
