package kim.adrian.auth.filter;

import com.adrian.common.entity.vo.AdrianResponse;
import com.adrian.common.exception.ValidateCodeException;
import com.adrian.common.utils.AdrianUtil;
import kim.adrian.auth.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName ValidateCodeFilter
 * @Description
 * @Date 2020-01-07 13:27
 */
@Slf4j
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    private final ValidateCodeService validateCodeService;

    public ValidateCodeFilter(ValidateCodeService validateCodeService) {
        this.validateCodeService = validateCodeService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RequestMatcher matcher = new AntPathRequestMatcher("/oauth/token", HttpMethod.POST.toString());
        String header = request.getHeader("Authorization");
        String clientId = getClientId(header, request);
        if (matcher.matches(request)
                && StringUtils.equalsIgnoreCase(request.getParameter("grant_type"), "password")
                && !StringUtils.equalsAnyIgnoreCase(clientId, "swagger")) {
            try {
                validateCode(request);
                filterChain.doFilter(request, response);
            } catch (ValidateCodeException e) {
                AdrianResponse adrianResponse = new AdrianResponse();
                AdrianUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR, adrianResponse.message(e.getMessage()));
                log.error(e.getMessage(), e);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private void validateCode(HttpServletRequest httpServletRequest) throws ValidateCodeException {
        String code = httpServletRequest.getParameter("code");
        String key = httpServletRequest.getParameter("key");
        validateCodeService.check(key, code);
    }

    private String getClientId(String header, HttpServletRequest request) {
        String clientId = "";
        try {
            byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
            byte[] decoded;
            decoded = Base64.getDecoder().decode(base64Token);

            String token = new String(decoded, StandardCharsets.UTF_8);
            int delis = token.indexOf(":");
            if (delis != -1) {
                clientId = new String[]{token.substring(0, delis), token.substring(delis + 1)}[0];
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return clientId;
    }
}
