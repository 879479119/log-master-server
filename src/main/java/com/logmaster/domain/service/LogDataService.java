package com.logmaster.domain.service;

import com.logmaster.domain.model.LogDataView;
import com.logmaster.domain.model.User;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface LogDataService extends BaseService<LogDataView> {

    /**
     * 获取详情.
     * @param id 日志id
     * @return 详情信息.
     */
    LogDataView getDetail(Integer id);

    void delete(Integer id);

}
