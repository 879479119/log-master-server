package com.logmaster.api.response.base;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */

public class Response {
    private RespMeta meta;
    private HashMap<String, Object> data;
    private PageResponse pagination;

    /**
     * add data.
     *
     * @param name   data name
     * @param object data object
     * @return this response
     */
    public Response addData(String name, Object object) throws JsonProcessingException {
        if (data == null) {
            data = new HashMap<String, Object>(20);
        }
        data.put(name, object);
        return this;
    }


    public RespMeta getMeta() {
        return meta;
    }

    public void setMeta(RespMeta meta) {
        this.meta = meta;
    }

    public Map getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public PageResponse getPagination() {
        return pagination;
    }

    public void setPagination(PageResponse pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "Response{" + "meta=" + meta + ", data=" + data + ", pagination=" + pagination + '}';
    }
}
