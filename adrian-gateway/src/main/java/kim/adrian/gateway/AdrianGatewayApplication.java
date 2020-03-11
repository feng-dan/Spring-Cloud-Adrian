package kim.adrian.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author feng-dan
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class AdrianGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdrianGatewayApplication.class, args);
    }

}
