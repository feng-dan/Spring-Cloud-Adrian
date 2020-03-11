package kim.adrian.test;

import com.adrian.common.annotation.AdrianCloudApplication;
import com.adrian.common.annotation.EnableAdrianAuthExceptionHandler;
import com.adrian.common.annotation.EnableAdrianOauth2FeignClient;
import com.adrian.common.annotation.EnableAdrianServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author feng-dan
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@AdrianCloudApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
