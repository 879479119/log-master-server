package com.logmaster.application.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglu
 * @Description: 修改历史常量
 * @Date: 2017/10/25.
 */

public class LogConstants {
    /**
     * 日志状态.
     **/
    public static final int LOG_STATUS_BASE_INFO_FINISH = 0;
    public static final int LOG_STATUS_KEY_FINISH = 1;
    public static final int LOG_STATUS_AUDIT_PASS = 2;
    public static final int LOG_STATUS_DEVELOPMENT_FINISH = 3;
    public static final int LOG_STATUS_TEST_FINISH = 4;
    public static final int LOG_STATUS_ONLINE = 5;
    public static final int LOG_STATUS_FIX_BUG = 6;
    public static final Map<Integer, String> KEY_STATUS_MAP = new HashMap<Integer, String>() {
        {
            put(LOG_STATUS_BASE_INFO_FINISH,"基本信息设计完成");
            put(LOG_STATUS_KEY_FINISH, "埋点字段设计完成");
            put(LOG_STATUS_AUDIT_PASS, "审核通过");
            put(LOG_STATUS_DEVELOPMENT_FINISH, "开发完成");
            put(LOG_STATUS_TEST_FINISH, "测试通过");
            put(LOG_STATUS_ONLINE, "已上线");
            put(LOG_STATUS_FIX_BUG, "埋点线上出现问题");
        }
    };
}
