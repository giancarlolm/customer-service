package com.mitocode.customer_service.dao;

import com.mitocode.customer_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long> {
}
