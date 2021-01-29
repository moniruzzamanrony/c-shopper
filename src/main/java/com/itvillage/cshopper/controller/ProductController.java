package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.dto.response.ProductResponse;
import com.itvillage.cshopper.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    @GetMapping("info")
    public ResponseEntity<ProductResponse> getData()
    {
        return productService.getData();
    }
}
