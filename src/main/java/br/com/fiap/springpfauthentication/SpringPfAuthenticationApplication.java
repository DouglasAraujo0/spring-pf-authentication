package br.com.fiap.springpfauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringPfAuthenticationApplication {

    public static void main(String[] args) {

        SpringApplication.run( SpringPfAuthenticationApplication.class, args );
    }

    @GetMapping(value = "/")
    public String index() {
        return "Seja bem-vindo";
    }

}

