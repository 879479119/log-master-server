package com.logmaster.application.utils;

import org.apache.http.client.methods.HttpPost;

/**
 * http工具.
 *
 * @author wanglu
 */

public class HttpGetWithEntity extends HttpPost {

    public static final String METHOD_NAME = "GET";

    public HttpGetWithEntity(String url) {
        super(url);
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
}
