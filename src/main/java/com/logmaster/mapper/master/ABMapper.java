package com.logmaster.mapper.master;

import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.Column;
import com.logmaster.domain.model.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

@Component
public interface ABMapper {
    /**
     * M查询日志list.
     * @param aBTestView 日志bean
     * @param pagination 分页bean
     * @return 日志列表
     */
    List<ABTestView> getLogDataList(@Param("aBTestView") ABTestView aBTestView, @Param("page") Pagination pagination);

    /**
     * 查询日志列表条数.
     * @param aBTestView 日志bean
     * @return 总条数
     */
    Integer getLogDataNums(@Param("aBTestView") ABTestView aBTestView);

    /**
     * 新增日志.
     * @param aBTestView 日志bean.
     * @return 主键id
     */
    Integer addLogData(@Param("ab") ABTestView aBTestView);

    void addColumnData(@Param("params") List<com.logmaster.domain.model.Param> params);

    /**
     * 修改日志信息.
     * @param aBTestView 日志bean
     */
    void editLogData(@Param("aBTestView") ABTestView aBTestView);

    void delColumnData(@Param("id") int id);

    /**
     * 获取日志详情.
     * @param id 日志id
     * @return 日志详情
     */
    ABTestView getABTestView(@Param("id") Integer id);

    List<com.logmaster.domain.model.Param> getColumnList(@Param("id") Integer id);

    void delete(@Param("id") Integer id);
}
