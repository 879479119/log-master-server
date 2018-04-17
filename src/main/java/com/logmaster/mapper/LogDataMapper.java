package com.logmaster.mapper;


import com.logmaster.domain.model.LogDataView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface LogDataMapper {
    /**
     * 查询日志list.
     * @param logDataView 日志bean
     * @param pagination 分页bean
     * @param user 用户
     * @return 日志列表
     */
    List<LogDataView> getLogDataList(@Param("logDataView") LogDataView logDataView, @Param("page") Pagination pagination, @Param("user") User user);

    /**
     * 查询日志列表条数.
     * @param logDataView 日志bean
     * @param user 用户
     * @return 总条数
     */
    Integer  getLogDataNums(@Param("logDataView") LogDataView logDataView, @Param("user") User user);

    /**
     * 新增日志.
     * @param logDataView 日志bean.
     * @return 主键id
     */
    Integer addLogData(@Param("logDataView") LogDataView logDataView);

    /**
     * 修改日志信息.
     * @param logDataView 日志bean
     */
    void editLogData(@Param("logDataView") LogDataView logDataView);

    /**
     * 获取日志详情.
     * @param id 日志id
     * @param user 用户
     * @return 日志详情
     */
    LogDataView getLogDataView(@Param("id") Integer id, @Param("user") User user);


    /**
     * 校验当前日志名是否唯一.
     * @param logDataView 日志bean
     * @return 满足条件的个数
     */
    Integer checkUniqueLogData(@Param("logDataView") LogDataView logDataView);


    /**
     * 日志名自动补全.
     * @param logDataView 日志bean
     * @return 日志名集合
     */

    List<String> dataNameComplete(@Param("logDataView") LogDataView logDataView);

    /**
     * task名自动补全.
     * @param logDataView 日志bean
     * @return 任务名集合
     */

    List<String> taskComplete(@Param("logDataView") LogDataView logDataView);
}
