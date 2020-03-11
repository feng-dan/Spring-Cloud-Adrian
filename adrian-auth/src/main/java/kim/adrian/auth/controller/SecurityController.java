package kim.adrian.auth.controller;

import com.adrian.common.entity.vo.Result;
import com.adrian.common.exception.SystemErrorType;
import com.adrian.common.exception.AdrianAuthException;
import com.adrian.common.exception.ValidateCodeException;
import kim.adrian.auth.service.ValidateCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName SecurityController
 * @Description
 * @Date 2019-12-17 22:12
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public Result signout(HttpServletRequest request) throws AdrianAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        if (!consumerTokenServices.revokeToken(token)) {
            throw new AdrianAuthException(SystemErrorType.LOGOUT_FAILED);
        }
        return Result.success("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

}
