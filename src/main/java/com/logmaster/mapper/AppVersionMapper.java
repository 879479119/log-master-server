package com.logmaster.mapper;


import com.logmaster.domain.model.AppVersion;
import com.logmaster.domain.model.AppVersionView;
import com.logmaster.domain.model.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface AppVersionMapper {
    /**
     * 查询app版本列表.
     * @param appVersionView app版本bean
     * @param pagination 页面bean
     * @return app版本集合
     */
    List<AppVersionView> getAppVersionList(@Param("appVersionView") AppVersionView appVersionView, @Param("page") Pagination pagination);

    /**
     * 查询app版本条数.
     * @param appVersionView app版本bean
     * @return 总条数
     */
    Integer getAppVersionNums(@Param("appVersionView") AppVersionView appVersionView);

    /**
     * 新增app版本.
     * @param appVersionView app版本bean
     * @return 主键ID
     */
    Integer addAppVersion(@Param("appVersionView") AppVersionView appVersionView);

    /**
     * 修改app版本.
     * @param appVersionView app版本bean
     */
    void editAppVersion(@Param("appVersionView") AppVersionView appVersionView);

    /**
     * 获取app版本详情.
     * @param id 主键id
     * @return app版本详情
     */
    AppVersionView getAppVersionDetail(Integer id);

    /**
     * 查询当前平台所有appVersion.
     * @param appId 应用ID
     * @return 所有appVersion
     */
    List<AppVersionView> getAllAppVersion(@Param("appId") Integer appId);
}
