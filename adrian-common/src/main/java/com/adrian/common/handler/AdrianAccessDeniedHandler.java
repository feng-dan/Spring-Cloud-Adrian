package com.adrian.common.handler;

import com.adrian.common.entity.vo.AdrianResponse;
import com.adrian.common.utils.AdrianUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAccessDeniedHandler
 * @Description
 * @Date 2019-12-31 18:31
 */
@Slf4j
public class AdrianAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        AdrianResponse adrianResponse = new AdrianResponse();
        AdrianUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_FORBIDDEN,
                adrianResponse.message("没有权限访问该资源"));
    }
}
