package com.mitocode.customer_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TestService {

    private Random random = new Random();
    private final ErrorProducerService errorProducerService;


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
        errorProducerService.sendCustomErrorMessage(
                "/test",
                "GET",
                500,
                "Error processing user: " + t.getMessage(),
                String.format("{\"test\":,\"operation\":\"testOperation\"}")
        );

        return "Acciones a considerar";
    }
}
