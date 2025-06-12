package com.mitocode.customer_service.controller;

import com.mitocode.customer_service.dto.CustomerRequest;
import com.mitocode.customer_service.dto.ProductDTO;
import com.mitocode.customer_service.entity.User;
import com.mitocode.customer_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getProductById(id));
    }


    @PostMapping
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Crea un nuevo cliente en el sistema con toda la información requerida"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerRequest.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "Ya existe un cliente con el mismo nombre",
                    content = @Content(mediaType = "application/json"))
    })
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<User> createProduct(
            @RequestBody @Parameter(description = "Datos para creación del cliente", required = true)
            @Valid CustomerRequest request
    ) {
        User response = userService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}