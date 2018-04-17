package com.logmaster.application.constants;

import com.logmaster.domain.enums.ModSourceEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglu
 * @Description: 修改历史常量
 * @Date: 2017/10/25.
 */

public class HistoryConstants {

    /**
     * 修改类型.
     **/

    /**
     * 新增.
     */
    public static final int MOD_ADD = 1;
    /**
     * 删除.
     */
    public static final int MOD_DELETE = 2;
    /**
     * 编辑.
     */
    public static final int MOD_EDIT = 3;

    public static final String DEFAUT_PROCESID = "";

    public static final String DEFAUT_DESC = "";

    public static final String DEFAUT_MOD_USER = "system";


    public static final Map<Integer, String> MOD_SOURCE_MAP = new HashMap<Integer, String>() {
        {
            put(ModSourceEnum.MOD_SOURCE_ADD.getId(), "新增");
            put(ModSourceEnum.MOD_SOURCE_EDIT.getId(), "编辑");
            put(ModSourceEnum.MOD_SOURCE_SYSTEM.getId(), "系统扫描");
            put(ModSourceEnum.MOD_SOURCE_DDL.getId(), "DDL");
        }
    };
}
