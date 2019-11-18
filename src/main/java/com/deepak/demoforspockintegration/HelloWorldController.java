package com.deepak.demoforspockintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public void helloWorld() {
        System.out.println("HEllooooooooooooooo");
    }

    @GetMapping("/double")
    public double doubleMethod() {
        System.out.println("HEllooooooooooooooo");
        return 22.00;
    }


}
