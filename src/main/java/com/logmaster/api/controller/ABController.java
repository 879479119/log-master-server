package com.logmaster.api.controller;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.LogDataView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.service.ABService;
import com.logmaster.domain.service.LogDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/ab")
public class ABController {

    private static Logger logger = LoggerFactory.getLogger(ABController.class);

    @Autowired
    ABService abService;

    /**
     * 查询日志列表.
     *
     * @param page        第几页
     * @param pageSize    每页大小
     * @param orderBy     排序字段
     * @param orderType   排序类型
     * @return 列表集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response getABList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "1000") Integer pageSize,
                                 @RequestParam(required = false, defaultValue = "create_time") String orderBy,
                                 @RequestParam(required = false, defaultValue = "DESC") String orderType,
                                 ABTestView abTestView,
                                 HttpServletRequest request) {
        try {
            Pagination pagination = new Pagination((page - 1) * pageSize, pageSize, orderBy, orderType);
            QueryTransformUtil<ABTestView> queryTransformUtil = new QueryTransformUtil<>();
            queryTransformUtil.transformQuery(abTestView);
            List<ABTestView> logList = abService.getList(abTestView, pagination);
            Integer totalItems = abService.getNums(abTestView);
            return Responses.pagedResponse(totalItems, page, pageSize).addData("list", logList);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.LISTERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.LISTERROR.getErrorCode(), ErrorCodeEnum.LISTERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addLog(@RequestBody ABTestView abTestView, HttpServletRequest request) {
        try {
            if (abTestView.getId() != null) {
                return Responses.errorResponse(ErrorCodeEnum.SAVEERROR.getErrorCode(), ErrorCodeEnum.SAVEERROR.getErrorName());
            }
            int percentage = abTestView.getPercentage();

            String array[] = ABController.randomArray(0, 1000, percentage);

            StringBuilder stringBuilder = new StringBuilder();

            for (String t : array) {
                stringBuilder.append(t);
                stringBuilder.append(',');
            }

            // 这个东西的使用人的hash值是不允许更改的

            abTestView.setHash(stringBuilder.toString());

            Integer abId = abService.add(abTestView);
            return Responses.successResponse().addData("abId", abId);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.SAVEERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.SAVEERROR.getErrorCode(), ErrorCodeEnum.SAVEERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response editLog(@RequestBody ABTestView abTestView, HttpServletRequest request) {
        try {
            if (abTestView.getPercentage() == 0) {

            }
            abService.edit(abTestView);
            return Responses.successResponse();
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.UPDATEERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.UPDATEERROR.getErrorCode(), ErrorCodeEnum.UPDATEERROR.getErrorName());
        }
    }

    /**
     * 查询日志详情.
     *
     * @param id 日志id
     * @return 日志详情
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response getLogDetail(@PathVariable Integer id, HttpServletRequest request) {
        try {
            ABTestView abTestView = abService.getDetail(id);
            return Responses.successResponse().addData("detail", abTestView);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response getLogDetail(@PathVariable Integer id) {
        try {
            abService.delete(id);
            return Responses.successResponse();
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    private static String[] randomArray(int min,int max,int n){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        String[] result = new String[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = String.format("%03d", source[index]);
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
}
