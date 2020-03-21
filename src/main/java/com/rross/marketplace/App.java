package com.rross.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class App {

    @RequestMapping("/")
    @ResponseBody
    String healthy() {
        return "Up & Healthy";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
