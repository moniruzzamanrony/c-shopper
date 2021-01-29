package com.itvillage.cshopper.services;


import com.itvillage.cshopper.dto.mapper.ProductsMapper;
import com.itvillage.cshopper.dto.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@AllArgsConstructor
public class ProductService {


    private final ProductsMapper productsMapper;

    public ResponseEntity<ProductResponse> getData() {

        ProductResponse productResponse  =  new ProductResponse();
        productResponse.setProductName("name");
        productResponse.setProductDetails("name");
        productResponse.setProductBrandName("name");
        productResponse.setProductDetails("setProductDetails");
        productResponse.setProductPrice("setProductPrice");
        productResponse.setProductSubTitle("sub name");
        productResponse.setProductName("setProductSubTitle");

        return new ResponseEntity(productsMapper.getProductCardMapper(productResponse), HttpStatus.OK);
    }
}
