package com.mitocode.customer_service.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Objeto request de Customer")
@Data
public class CustomerRequest {


    @Schema(description = "Campo del nombre de usuario")
    private String name;

}
