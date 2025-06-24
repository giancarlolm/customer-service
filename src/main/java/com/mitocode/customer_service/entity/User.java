package com.mitocode.customer_service.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Objeto usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name")
    private String username;
    @Column(name = "legal_name")
    private String description;


}
