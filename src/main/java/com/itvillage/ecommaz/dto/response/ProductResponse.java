package com.itvillage.ecommaz.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductResponse {

    private Long productId;

    private String productName;

    private String productBrandName;

    private String productGroupName;

    private String productSubTitle;

    private String productQuantity;

    private String productPrice;

    private String productDetails;

    private String productImageUrl;
}
