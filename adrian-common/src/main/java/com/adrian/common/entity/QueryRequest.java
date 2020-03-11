package com.adrian.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName QueryRequest
 * @Description 通用查询参数类，用于接收前端上送的分页和排序信息
 * @Date 2020-01-07 15:09
 */
@Data
public class QueryRequest implements Serializable {
    private static final long serialVersionUID = -4869594085374385813L;
    /**
     * 当前页面数据量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String fieId;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;
}
