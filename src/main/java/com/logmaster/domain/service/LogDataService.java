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
     * @param user 用户
     * @return 详情信息.
     */
    LogDataView getDetail(Integer id, User user);

}
