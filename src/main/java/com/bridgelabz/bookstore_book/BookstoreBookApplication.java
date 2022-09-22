package com.bridgelabz.bookstore_book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class BookstoreBookApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();


    }
    public static void main(String[] args) {
        SpringApplication.run(BookstoreBookApplication.class, args);
    }

}

