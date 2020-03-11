package kim.adrian.gateway.filter;

import com.adrian.common.entity.vo.AdrianResponse;
import com.adrian.common.utils.AdrianUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianGatewayErrorFilter
 * @Description
 * @Date 2020-01-03 11:43
 */
@Slf4j
@Component
public class AdrianGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            AdrianResponse adrianResponse = new AdrianResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            adrianResponse = resolveExceptionMessage(message, serviceId, adrianResponse);
            HttpServletResponse response = ctx.getResponse();
            AdrianUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, adrianResponse);
            log.error("Zuul sendError：{}", adrianResponse.getMessage());
        } catch (IOException ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private AdrianResponse resolveExceptionMessage(String message, String serviceId, AdrianResponse adrianResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return adrianResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return adrianResponse.message(serviceId + "服务不可用");
        }
        return adrianResponse.message("Zuul请求" + serviceId + "服务异常");
    }

}
