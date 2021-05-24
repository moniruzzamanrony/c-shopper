package com.itvillage.cshopper.repository;

import com.itvillage.cshopper.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findById(String id);

    List<Product> findAllById(String id);

}
