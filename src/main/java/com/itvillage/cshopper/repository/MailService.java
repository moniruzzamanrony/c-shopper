package com.itvillage.cshopper.repository;

import org.springframework.web.bind.annotation.RequestBody;

public interface MailService {

    Object sendMail(String userName,String address ,String email ,String phone,String productPrice,String productTotal);
}
