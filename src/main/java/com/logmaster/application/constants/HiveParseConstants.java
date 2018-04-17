package com.logmaster.application.constants;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglu
 * @Description: HIVE语法树解析常量
 * @Date: 2017/11/28.
 */

public class HiveParseConstants {
    /** 切换hive库.*/
    public static final String SWITCHDATABASE = "TOK_SWITCHDATABASE";
    /** 删除hive库.*/
    public static final String DROPDATABASE = "TOK_DROPDATABASE";
    /** 创建表.*/
    public static final String CREATETABLE = "TOK_CREATETABLE";
    /** 删除表.*/
    public static final String DROPTABLE = "TOK_DROPTABLE";
    /** 修改表.*/
    public static final String ALTERTABLE = "TOK_ALTERTABLE";
    /** 新增列.*/
    public static final String ALTERTABLE_ADDCOLS = "TOK_ALTERTABLE_ADDCOLS";
    /** 重命名列.*/
    public static final String ALTERTABLE_RENAMECOL = "TOK_ALTERTABLE_RENAMECOL";
    /** 重命名表.*/
    public static final String ALTERTABLE_RENAME = "TOK_ALTERTABLE_RENAME";
    /** 替换列.*/
    public static final String ALTERTABLE_REPLACECOLS = "TOK_ALTERTABLE_REPLACECOLS";

    public static final String TABCOLLIST = "TOK_TABCOLLIST";

    public static final String TABLECOMMENT = "TOK_TABLECOMMENT";

    public static final String TABLELOCATION = "TOK_TABLELOCATION";

    public static final String EXTERNAL = "EXTERNAL";

    public static final String TABNAME = "TOK_TABNAME";

    public static final String IFNOTEXISTS = "TOK_IFNOTEXISTS";

    public static final String BASE_START_1 = "'";

    public static final String BASE_START_2 = "\"";

    public static final String COMMENT_EMPTY_1 = "''";

    public static final String COMMENT_EMPTY_2 = "\"\"";

    public static final String LINE_FEED = "\n";

    public static final String BLANK = " ";

    public static final Map<String, Integer> LEVEL_TYPE_MAP = new HashMap<String, Integer>() {
        {
            put("src", 6001);
            put("ods", 6002);
            put("dwb", 6003);
            put("dw", 6004);
            put("ads", 6005);
        }
    };


}
