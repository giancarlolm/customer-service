package com.mitocode.customer_service.controller;


import com.mitocode.customer_service.entity.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="PRODUCT-SERVICE")
@RequestMapping("producto")
public interface ProductoProxy {
    @GetMapping (path="/{id}")
    public ResponseEntity<Producto> getId(@PathVariable("id") Long id);
}
