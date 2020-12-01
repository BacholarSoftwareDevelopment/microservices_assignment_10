package dk.oertel.discserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscserverApplication.class, args);
    }

}
