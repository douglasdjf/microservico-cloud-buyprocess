package com.mscomunication.buyprocess.client.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class AutoConfiguration {

    @Bean
    public RequestInterceptor interceptor(){
        return requestTemplate -> {
            requestTemplate.header("Accept","application/json");
        };
    }

}
