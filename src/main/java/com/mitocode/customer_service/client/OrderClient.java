package com.mitocode.customer_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ORDER-SERVICE")
public interface OrderClient {

    @GetMapping("/order/list")
    List<Long> getList();

}
