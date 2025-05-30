package com.mitocode.customer_service.dto;

import com.mitocode.customer_service.entity.Producto;
import lombok.Data;

import java.util.List;


@Data
public class ProductCustomerDTO {

    private String name;
    private Long id;

    private List<Producto> productoList;


}
