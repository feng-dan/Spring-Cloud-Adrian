package com.adrian.common.entity.form;

import com.adrian.common.entity.po.BasePo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName BaseForm
 * @Description
 * @Date 2020-01-07 15:49
 */
@Data
@Slf4j
public class BaseForm<T extends BasePo> {
    private String username;

    /**
     * From转化为Po，进行后续业务处理
     *
     * @param tClass tClass
     * @return T
     */
    public T toPo(Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Po NewInstance Error");
        }
        assert t != null;
        BeanUtils.copyProperties(this, t);
        return t;
    }
}
