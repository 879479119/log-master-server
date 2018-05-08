package com.logmaster.mapper.master;


import com.logmaster.domain.model.Business;
import com.logmaster.domain.model.Page;
import com.logmaster.domain.model.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public interface BusinessMapper {

    /**
     * 根据业务id查询对应页面列表.
     * @param id 业务id
     * @return 页面集合
     */
    List<Page> getPageList(@Param("id") Integer id);

    /**
     * 校验当前业务名是否唯一.
     * @param business 业务bean
     * @return 满足条件的个数
     */
    Integer checkUniqueBusiness(@Param("business") Business business);


    /**
     * 根据业务信息查询业务名.
     * @param business 业务bean
     * @return 业务名集合
     */

    List<Business> businessComplete(@Param("business") Business business);


}
