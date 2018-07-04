package com.logmaster.mapper.master;


import com.logmaster.domain.model.Column;
import com.logmaster.domain.model.LogDataView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

@Component
public interface LogDataMapper {
    /**
     * 查询日志list.
     * @param logDataView 日志bean
     * @param pagination 分页bean
     * @return 日志列表
     */
    List<LogDataView> getLogDataList(@Param("logDataView") LogDataView logDataView, @Param("page") Pagination pagination);

    /**
     * 查询日志列表条数.
     * @param logDataView 日志bean
     * @return 总条数
     */
    Integer getLogDataNums(@Param("logDataView") LogDataView logDataView);

    /**
     * 新增日志.
     * @param logDataView 日志bean.
     * @return 主键id
     */
    Integer addLogData(@Param("log") LogDataView logDataView);

    void addColumnData(@Param("columns") List<Column> columns, @Param("parent") Integer id);

    /**
     * 修改日志信息.
     * @param logDataView 日志bean
     */
    void editLogData(@Param("logDataView") LogDataView logDataView);

    void delColumnData(@Param("id") int id);

    /**
     * 获取日志详情.
     * @param id 日志id
     * @return 日志详情
     */
    LogDataView getLogDataView(@Param("id") Integer id);

    void delete(@Param("id") Integer id);
}
