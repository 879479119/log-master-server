package com.logmaster.application.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @param <T> 泛型
 * @author wanglu
 * @Date: 2017/12/22.
 */

public class QueryTransformUtil<T> {
    /**
     * 转义查询条件特殊符号.
     * @param entity 实体
     * @return 实体
     */
    public T transformQuery(T entity) {
        Field[] field = entity.getClass().getDeclaredFields();//cHis 是实体类名称
        for (int i = 0; i < field.length; i++) {
            String name = field[i].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = null;
            try {
                method = entity.getClass().getMethod("get" + name);
                if (field[i].getType().equals(String.class)) {
                    String value = (String) method.invoke(entity);
                    if (Check.notEmpty(value)) {
                        method = entity.getClass().getMethod("set" + name, String.class);
                        method.invoke(entity, replaceStr(value));
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return entity;
    }

    private String replaceStr(String value) {
        return value.replace("'", "\\\'")
                .replace("\"", "\\\"");
    }


}
