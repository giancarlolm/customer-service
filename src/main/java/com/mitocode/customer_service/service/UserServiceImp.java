package com.mitocode.customer_service.service;

import com.mitocode.customer_service.client.ProductClient;
import com.mitocode.customer_service.dao.UserDAO;
import com.mitocode.customer_service.dto.CustomerRequest;
import com.mitocode.customer_service.dto.ProductDTO;
import com.mitocode.customer_service.entity.Customer;
import com.mitocode.customer_service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ProductClient productClient;

    @Override
    @Cacheable(value = "users", key = "#id")
    public User getById(Long id) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userDAO.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Usuario no encontrado"
        ));
    }

    @Override
    public User createCustomer(CustomerRequest request) {

        User user = User.builder()
                .username(request.getName())
                .build();

        return userDAO.save(user);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productClient.getProdct(id);
    }
}
