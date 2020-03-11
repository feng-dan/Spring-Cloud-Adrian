package kim.adrian.test.service.fallback;

import feign.hystrix.FallbackFactory;
import kim.adrian.test.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName HelloServiceFallback
 * @Description
 * @Date 2020-01-03 13:10
 */
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {

    @Override
    public IHelloService create(Throwable cause) {
        return name -> {
            log.error("调用adrian-server-system服务出错 ", cause);
            return "调用出错";
        };
    }
}
