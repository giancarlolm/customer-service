package com.mitocode.customer_service.controller;

import com.mitocode.customer_service.service.TestProxy;
import com.mitocode.customer_service.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customer")
public class TestController {

    @Autowired
    private TestProxy testProxy;

    @Autowired
    private TestService testService;


    @GetMapping("hola")
    public String getHola() {
        return testService.getName();
    }


}
