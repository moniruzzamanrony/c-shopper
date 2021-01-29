package com.itvillage.cshopper.dto.mapper;


import com.itvillage.cshopper.dto.response.ProductResponse;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsMapper {

   // ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productSubTitle", target = "productSubTitle")
    @Mapping(source = "productPrice", target = "productPrice")
    ProductResponse getProductCardMapper(ProductResponse productResponse);

}
