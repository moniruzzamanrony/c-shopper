package com.itvillage.cshopper.services;


import com.itvillage.cshopper.domain.Product;
import com.itvillage.cshopper.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Setter
@Getter
@AllArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void save(Product product) {

        productRepository.save(product);
    }

    public Product get(String id) {

        return productRepository.findById(id).get();
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> show() {
        List<Product> products = new ArrayList<Product>();
        for (Product product : productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }


    public Product editProduct(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        System.out.print("listall"+productOptional.get());
        return productOptional.get();


    }

    public Product getEmployeeById(String id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return product;
    }

    public List<Product> findAllById(String id) {
        List<Product> products = new ArrayList<Product>();
        for (Product product : productRepository.findAllById(id)) {
            products.add(product);
        }
        return products;
    }

}
