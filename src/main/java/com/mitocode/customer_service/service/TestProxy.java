package com.mitocode.customer_service.service;

import com.mitocode.customer_service.entity.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PRODUCT-SERVICE")
public interface TestProxy {

    @GetMapping("/product/name")
    String getName();

    @PostMapping("/product/save")
    String saveProduct(@RequestBody Producto producto);

    @PutMapping("/product/edit")
    String editProdct(@PathVariable("id") Long id);

}
