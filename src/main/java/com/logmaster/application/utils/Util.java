package com.logmaster.application.utils;


import com.logmaster.application.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */
public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);


    /**
     * 打印异常的堆栈信息.
     *
     * @param exception 异常
     * @return String
     */

    public static String getExceptionMessage(Exception exception) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 把异常的堆栈信息写入StringWriter
            exception.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }

        return sw.toString();
    }

    /**
     * 获取时间.
     **/
    public static String getTimeStr(Date time) {
        if (time == null) {
            return "";
        } else {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format((time));
        }

    }

    /**
     * 格式化开始时间.
     *
     * @param time yyyy-mm-dd
     */

    public static Date getStartTime(String time) {
        time = time + " 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            if (!time.equals(Constants.EMPTY_STRING)) {
                date = format.parse(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化结束时间.
     *
     * @param time yyyy-mm-dd
     */

    public static Date getEndTime(String time) {
        time = time + " 23:59:59";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            if (!time.equals(Constants.EMPTY_STRING)) {
                date = format.parse(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static String bytesToHexString(byte[] bytes) {
        // http://stackoverflow.com/questions/332079
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}
