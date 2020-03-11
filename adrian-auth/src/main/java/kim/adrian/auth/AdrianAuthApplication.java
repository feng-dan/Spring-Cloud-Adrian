package kim.adrian.auth;

import com.adrian.common.annotation.AdrianCloudApplication;
import com.adrian.common.annotation.EnableAdrianAuthExceptionHandler;
import com.adrian.common.annotation.EnableAdrianLettuceRedis;
import com.adrian.common.annotation.EnableAdrianServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author feng-dan
 */
@EnableDiscoveryClient
@SpringBootApplication
@AdrianCloudApplication
@EnableAdrianLettuceRedis
@MapperScan(value = "kim.adrian.auth.mapper")
public class AdrianAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdrianAuthApplication.class, args);
    }

}
