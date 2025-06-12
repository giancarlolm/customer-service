package com.mitocode.customer_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ProductDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
