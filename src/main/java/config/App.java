package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"domain", "service", "rest", "config"})
@EnableFeignClients({"rest"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
