package com.itvillage.cshopper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@AllArgsConstructor
public class EmailBodyForm {


    private String username;

    private String exampleInputAddress;

    private String Phone;

    private String exampleInputEmail1;

    private String productPrice;

    private String productTotal;



}
