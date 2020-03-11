package kim.adrian.gateway.filter;

import com.adrian.common.entity.AdrianConstant;
import com.adrian.common.entity.vo.AdrianResponse;
import com.adrian.common.utils.AdrianUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import kim.adrian.gateway.properties.AdrianGatewayProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianGatewayRequestFilter
 * @Description
 * @Date 2020-01-03 13:28
 */
@Slf4j
@Component
public class AdrianGatewayRequestFilter extends ZuulFilter {

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    private final AdrianGatewayProperties properties;

    public AdrianGatewayRequestFilter(AdrianGatewayProperties properties) {
        this.properties = properties;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);

        //禁止外部访问资源实现
        boolean shouldForward = true;
        String forbidRequestUri = properties.getForbidRequestUri();
        String[] forbidRequestUris = StringUtils.splitByWholeSeparatorPreserveAllTokens(forbidRequestUri, ",");

        if (forbidRequestUris != null && ArrayUtils.isNotEmpty(forbidRequestUris)) {
            for (String requestUris : forbidRequestUris) {
                if (pathMatcher.match(requestUris, uri)) {
                    shouldForward = false;
                }
            }
        }

        if (!shouldForward) {
            HttpServletResponse response = ctx.getResponse();
            AdrianResponse adrianResponse = new AdrianResponse().message("该URI不允许外部访问");
            try {
                AdrianUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_FORBIDDEN, adrianResponse);
                ctx.setSendZuulResponse(false);
                ctx.setResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        byte[] token = Base64Utils.encode((AdrianConstant.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(AdrianConstant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}
