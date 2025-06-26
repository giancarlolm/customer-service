package com.mitocode.customer_service.controller;

import com.mitocode.customer_service.client.PaymentClient;
import com.mitocode.customer_service.client.ProductClient;
import com.mitocode.customer_service.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private PaymentClient paymentClient;


    @GetMapping("circuit")
    public String testCircuit(){
        return testService.circuit();
    }

    @GetMapping("hola")
    public String getHola() {
        return testService.getName();
    }

    @GetMapping("product")
    public String getHolaProducto(){
        return productClient.getHolaProduct();
    }

    @GetMapping("payment")
    public String getHolaPayment(){
        return paymentClient.getHola();
    }


}
