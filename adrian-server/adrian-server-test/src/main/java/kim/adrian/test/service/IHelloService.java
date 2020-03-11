package kim.adrian.test.service;

import com.adrian.common.entity.AdrianServerConstant;
import kim.adrian.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName IHolleService
 * @Description
 * @Date 2020-01-03 13:00
 */
@FeignClient(value = AdrianServerConstant.ADRIAN_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    /**
     * hello
     *
     * @param name
     * @return
     */
    @GetMapping("hello")
    String hello(@RequestParam(value = "name") String name);
}
