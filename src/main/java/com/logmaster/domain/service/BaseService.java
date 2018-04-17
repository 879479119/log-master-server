package com.logmaster.domain.service;


import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;

import java.util.List;

/**
 * 通用CRUD接口
 * @author wanglu
 * @Description:
 * @Date: 2017/10/19.
 * @param <T> 范型
 */

public interface BaseService<T> {

    /**
     * 分页查询.
     * @param bean 实体bean
     * @param pagination 分页bean
     * @return 返回集合
     */
    List<T> getList(T bean, Pagination pagination);

    /**
     * 列表条数.
     * @param bean 实体bean
     * @return 返回满足条件的条数
     */
    Integer getNums(T bean);

    /**
     * 新增.
     * @param bean 实体bean
     * @return 返回插入主键id
     */
    Integer add(T bean);

    /**
     * 修改.
     * @param bean 实体bean
     */
    void edit(T bean);

    /**
     * 根据ID获取详情.
     * @param id 主键id
     * @return 实体bean
     */
    T getDetail(Integer id);


}
