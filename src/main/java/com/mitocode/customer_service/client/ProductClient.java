package com.mitocode.customer_service.client;

import com.mitocode.customer_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

    @GetMapping("/product/{id}")
    ProductDTO getProdct(@PathVariable("id") Long id);

    @GetMapping("/product")
    List<ProductDTO> getAllProducts();

    @GetMapping("/product/hola")
    String getHolaProduct();
}