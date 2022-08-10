package br.com.fiap.riapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiApiApplication.class, args);

        System.out.println("----------------------");
        System.out.println("API NO AR");
        System.out.println("----------------------");
    }

}
