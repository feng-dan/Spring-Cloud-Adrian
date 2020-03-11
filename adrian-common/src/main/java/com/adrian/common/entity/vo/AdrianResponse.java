package com.adrian.common.entity.vo;

import java.util.HashMap;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianResponse
 * @Description
 * @Date 2019-12-17 22:14
 */
public class AdrianResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public AdrianResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public AdrianResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public Object put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
