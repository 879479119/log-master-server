package com.logmaster.application.utils;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author wanglu
 * @Description: 数据检查辅助类
 * @Date: 2017/10/25.
 */
public final class Check {

    /**
     * 判断boolean[] 是否为空.
     */
    public static boolean isEmpty(final boolean[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final byte[] bytes) {
        return null == bytes || bytes.length == 0;
    }

    /**
     * 判断char[] 是否为空.
     */
    public static boolean isEmpty(final char[] value) {
        return null == value || value.length == 0;
    }

    /**
     * 判断字符串是否为空字符串.
     *
     * @return true为空false不为空
     */
    public static boolean isEmpty(final CharSequence charstr) {
        return null == charstr || charstr.length() == 0;
    }

    /**
     * 判断CharSequence[] 是否为空.
     */
    public static boolean isEmpty(final CharSequence[] value) {
        return null == value || value.length == 0;
    }

    /**
     * 判断collection是否为空集合.
     * 为了防止 unchecked 编译警告而专门设置的函数
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }

    public static boolean isEmpty(final Date time) {
        return null == time || time.getTime() == 0;
    }

    /**
     * 判断int型数组是否为空.
     *
     * @return true为空, false不为空
     */
    public static boolean isEmpty(final int[] ints) {
        return null == ints || ints.length == 0;
    }

    /**
     * 判断Integer对象数组是否为空数组.
     */
    public static boolean isEmpty(final Integer[] strings) {
        return null == strings || strings.length == 0;
    }

    /**
     * 判断long型数组是否为空.
     */
    public static boolean isEmpty(final long[] longs) {
        return null == longs || longs.length == 0;
    }

    public static boolean isEmpty(final Long[] longs) {
        return null == longs || longs.length == 0;
    }

    /**
     * 判断Map是否为空映射.
     * 为了防止 unchecked 编译警告而专门设置的函数
     */

    public static boolean isEmpty(final Map<?, ?> map) {
        return null == map || map.size() == 0;
    }

    public static boolean isEmpty(final Object[] objects) {
        return null == objects || objects.length == 0;
    }

    /**
     * 判断字符串是否为空字符串.
     *
     * @return true为空false不为空
     */
    public static boolean isEmpty(final String strs) {
        return null == strs || strs.length() == 0;
    }

    /**
     * 判断字符串数组是否为空数组.
     */
    public static boolean isEmpty(final String[] strs) {
        return null == strs || strs.length == 0;
    }

    // /**
    // * 判断字符串是否是11位数字（手机号）.
    // *
    // * @param mobile
    // * @return
    // */
    // public static boolean isMobile(final String mobile)
    // {
    // if (NumberUtil.isNumeric(mobile) && mobile.length() == 11)
    // {
    // return true;
    // }
    // return false;
    // }

    // /**
    // * 验证是否手机号码（以英文逗号或分号分隔）
    // *
    // * @param mobiles
    // * 手机号码
    // * @return
    // */
    // public static boolean isMobiles(final String mobiles)
    // {
    // final String[] mobs = mobiles.split(",|;|，|；");
    // if (Check.isEmpty(mobs))
    // {
    // return false;
    // }
    // for (final String mob : mobs)
    // {
    // if (!isMobile(mob))
    // {
    // return false;
    // }
    // }
    // return true;
    // }

    /**
     * 判断boolean[] 是否非空.
     */
    public static boolean notEmpty(final boolean[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断byte[] 是否为空.
     */
    public static boolean notEmpty(final byte[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断char[] 是否非空.
     */
    public static boolean notEmpty(final char[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断字符串是否非空.
     *
     * @return true不为空, false为空
     */
    public static boolean notEmpty(final CharSequence strs) {
        return null != strs && strs.length() > 0;
    }

    /**
     * 判断CharSequence[] 是否非空.
     */
    public static boolean notEmpty(final CharSequence[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断Collection是否非空.
     *
     * @return ture集合不为空, false集合为空
     */
    public static boolean notEmpty(final Collection<?> collection) {
        return null != collection && collection.size() > 0;
    }

    public static boolean notEmpty(final Date time) {
        return null != time;
    }

    /**
     * 判断int型数组是否非空.
     *
     * @return true数组不为空, false数组为空
     */
    public static boolean notEmpty(final int[] ints) {
        return null != ints && ints.length > 0;
    }

    /**
     * 判断Integer对象数组是否非空.
     *
     * @return true不为空false为空
     */
    public static boolean notEmpty(final Integer[] ints) {
        return null != ints && ints.length > 0;
    }

    /**
     * 判断long型数组是否非空.
     *
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final long[] longs) {
        return null != longs && longs.length > 0;
    }

    public static boolean notEmpty(final Long[] longs) {
        return null != longs && longs.length > 0;
    }

    /**
     * 判断Map是否非空.
     *
     * @param map 映射
     * @return ture映射不为空, false映射为空
     */
    public static boolean notEmpty(final Map<?, ?> map) {
        return null != map && map.size() > 0;
    }

    /**
     * 判断Object[] 是否非空.
     */
    public static boolean notEmpty(final Object[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断字符串是否非空.
     *
     * @return true字符串不为空, false字符串为空
     */
    public static boolean notEmpty(final String str) {
        return null != str && str.length() > 0;
    }

    /**
     * 判断字符串数组是否非空.
     *
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final String[] str) {
        return null != str && str.length > 0;
    }

    /**
     * 私有构造函数.
     */
    private Check() {

    }
}
