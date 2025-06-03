package com.mitocode.customer_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @GetMapping("/payment/get/{id}")
    String getProdct(@PathVariable("id") Long id);

    @GetMapping("/payment/hola")
    String getHola();
}
