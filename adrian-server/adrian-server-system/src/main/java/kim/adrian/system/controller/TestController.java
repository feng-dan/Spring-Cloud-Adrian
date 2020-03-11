package kim.adrian.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName TestController
 * @Description
 * @Date 2019-12-25 23:47
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/info")
    public String test() {
        return "adrian-server-system";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name") String name) {
        log.info("/hello服务被调用");
        return "hello " + name;
    }
}
