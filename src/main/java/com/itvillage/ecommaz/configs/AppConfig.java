package com.itvillage.ecommaz.configs;

import com.itvillage.ecommaz.util.UuidUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtil uuidUtil() {
        return new UuidUtil();
    }


}
