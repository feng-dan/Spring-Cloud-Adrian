package kim.adrian.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author feng-dan
 */
@EnableEurekaServer
@SpringBootApplication
public class AdrianRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdrianRegisterApplication.class, args);
    }

}
