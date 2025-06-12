package com.mitocode.customer_service.service;

import com.mitocode.customer_service.dto.CustomerRequest;
import com.mitocode.customer_service.dto.ProductDTO;
import com.mitocode.customer_service.entity.Customer;
import com.mitocode.customer_service.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User getById(Long id);

    User createCustomer(@Valid CustomerRequest request);

    ProductDTO getProductById(Long id);
}
