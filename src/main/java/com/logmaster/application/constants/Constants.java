package com.logmaster.application.constants;


import com.logmaster.domain.enums.UserRoleEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量.
 *
 * @author wanglu
 *
 */
public class Constants {

    /**************************************************公共.****************************************************************/
    /**
     * 查找目标不存在.
     */
    public static final Integer NON_EXISTENT = 0;
    /**
     * 空字符串 .
     */
    public static final String EMPTY_STRING = "";

    public static final String SUCCESS = "SUCCESS";

    public static final String FAILED = "FAILED";


    public static final Map<Boolean, String> FLAG_MAP = new HashMap<Boolean, String>() {
        {
            put(true,"是");
            put(false, "否");
        }
    };

    /**************************************************tomcat.****************************************************************/

    public static final String SERVER_PORT = "server.port";

    /**************************************************用户相关.****************************************************************/
    /** HIVE审核组——有子权限组.*/
    public static final Integer HIVE_GROUP_ID = 100;
    /** 业务线审核组——有子权限组.*/
    public static final Integer BUSINESS_GROUP_ID = 200;

    public static final Map<Integer, String> ROLE_MAP = new HashMap<Integer, String>() {
        {
            put(UserRoleEnum.ORDINARY.getRole(),"普通用户");
            put(UserRoleEnum.RD.getRole(), "RD");
            put(UserRoleEnum.ADMIN.getRole(), "管理员");
            put(UserRoleEnum.SUPER_ADMIN.getRole(), "超级管理员");
        }
    };


    /**************************************************=hive相关.****************************************************************/


    public static final String DEFAULT_EXECUET_ACCOUNT = "zhihu";
}
