package kim.adrian.system;

import com.adrian.common.annotation.AdrianCloudApplication;
import com.adrian.common.annotation.EnableAdrianAuthExceptionHandler;
import com.adrian.common.annotation.EnableAdrianOauth2FeignClient;
import com.adrian.common.annotation.EnableAdrianServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author feng-dan
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@AdrianCloudApplication
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("kim.adrian.system.mapper")
public class AdrianServerSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdrianServerSystemApplication.class, args);
    }
}
