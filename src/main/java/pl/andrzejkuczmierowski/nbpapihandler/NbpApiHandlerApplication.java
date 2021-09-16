package pl.andrzejkuczmierowski.nbpapihandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NbpApiHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpApiHandlerApplication.class, args);
    }
}
