package com.adrian.common.interceptor;

import com.adrian.common.entity.AdrianConstant;
import com.adrian.common.entity.vo.AdrianResponse;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerProtectInterceptor
 * @Description
 * @Date 2020-01-03 13:33
 */
public class AdrianServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(AdrianConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(AdrianConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            AdrianResponse adrianResponse = new AdrianResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(adrianResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}
