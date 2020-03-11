package kim.adrian.test.controller;

import kim.adrian.test.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName TestController
 * @Description
 * @Date 2019-12-30 19:01
 */
@Slf4j
@RestController
public class TestController {

    private final IHelloService helloService;

    public TestController(IHelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1() {
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2() {
        return "拥有'user:update'权限";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name") String name) {
        log.info("Feign调用adrian-server-system的/hello服务");
        return helloService.hello(name);
    }
}
