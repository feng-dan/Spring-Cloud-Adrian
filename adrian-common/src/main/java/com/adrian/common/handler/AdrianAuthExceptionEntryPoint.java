package com.adrian.common.handler;

import com.adrian.common.entity.vo.AdrianResponse;
import com.adrian.common.utils.AdrianUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAuthExceptionEntryPoint
 * @Description 处理资源服务器异常
 * @Date 2019-12-31 17:42
 */
@Slf4j
public class AdrianAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        AdrianResponse adrianResponse = new AdrianResponse();
        AdrianUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED,adrianResponse.message("token无效"));
    }
}
