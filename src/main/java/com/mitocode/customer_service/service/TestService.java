package com.mitocode.customer_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class TestService {

    private Random random = new Random();

    public String getName() {
        return "Hola";
    }

    @CircuitBreaker(name = "customerService", fallbackMethod = "fallback")
    @Retry(name = "customerService")
    public String circuit() {
        if (random.nextBoolean()) {
            throw new RuntimeException("Error o.O");
        }
        return "Respuesta exitosa: " + LocalDateTime.now();
    }


    public String fallback(Throwable t) {
        // Aqui se puede colocar cualquier otra acción como un servicio Async
        return "Acciones a considerar";
    }
}
