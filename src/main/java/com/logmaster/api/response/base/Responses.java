package com.logmaster.api.response.base;

import java.util.HashMap;

public class Responses {

    /**
     * build success response.
     *
     * @return response
     */
    public static Response successResponse() {
        Response response = new Response();

        RespMeta meta = new RespMeta();
        meta.setCode(0);
        response.setMeta(meta);

        return response;
    }

    /**
     * build success response.
     *
     * @param data response data
     * @return success response
     */
    public static Response successResponse(HashMap data) {
        Response response = new Response();

        RespMeta meta = new RespMeta();
        meta.setCode(0);
        response.setMeta(meta);

        response.setData(data);

        return response;
    }

    /**
     * build error response.
     *
     * @param errorMsg error msg
     * @return response
     */
    public static Response errorResponse(String errorMsg) {

        RespMeta meta = new RespMeta();
        meta.setCode(1);
        meta.setErrorType("UNKNOW");
        meta.setErrorMsg(errorMsg);

        Response response = new Response();
        response.setMeta(meta);

        return response;
    }

    /**
     * build error response.
     *
     * @param code     error code
     * @param errorMsg error msg
     * @return response
     */
    public static Response errorResponse(int code, String errorMsg) {

        RespMeta meta = new RespMeta();
        meta.setCode(code);
        meta.setErrorType("UNKNOW");
        meta.setErrorMsg(errorMsg);

        Response response = new Response();
        response.setMeta(meta);

        return response;
    }

    /**
     * build error response.
     *
     * @param code      error code
     * @param errorType error type
     * @param errorMsg  error msg
     * @return response
     */
    public static Response errorResponse(int code, String errorType, String errorMsg) {

        RespMeta meta = new RespMeta();
        meta.setCode(code);
        meta.setErrorType(errorType);
        meta.setErrorMsg(errorMsg);

        Response response = new Response();
        response.setMeta(meta);

        return response;
    }

    /**
     * build paged response.
     *
     * @param totalItems total items
     * @param pageNum    page num
     * @param pageSize   page size
     * @return response
     */
    public static Response pagedResponse(Integer totalItems, Integer pageNum, Integer pageSize) {
        Response response = new Response();

        RespMeta meta = new RespMeta();
        meta.setCode(0);
        response.setMeta(meta);

        PageResponse pagination = new PageResponse();
        pagination.setTotalItems(totalItems == null ? 0 : totalItems);
        pagination.setPageNum(pageNum);
        pagination.setPageSize(pageSize);
        response.setPagination(pagination);

        return response;
    }
}