package com.logmaster.domain.service;


import com.logmaster.domain.model.ABTestView;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface ABService extends BaseService<ABTestView> {

    /**
     * 获取详情.
     * @param id 日志id
     * @return 详情信息.
     */
    ABTestView getDetail(Integer id);

}
