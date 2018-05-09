package com.logmaster.api.controller;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.Column;
import com.logmaster.domain.model.PerDay;
import com.logmaster.domain.service.ABService;
import com.logmaster.domain.service.AnalysisService;
import com.logmaster.domain.service.ContrastService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/contrast")
public class ContrastController {

    private static Logger logger = LoggerFactory.getLogger(ContrastController.class);

    @Autowired
    ContrastService contrastService;

    @Autowired
    ABService abService;

    @RequestMapping(value = "/stayTime", method = RequestMethod.GET)
    public Response stayTime(@Param("testId") int testId, @Param("page") String page) {
        try {
            List<com.logmaster.domain.model.Param> params = abService.getColumnList(testId);

            HashMap<String, List<PerDay>> ret = new HashMap<>();

            for (com.logmaster.domain.model.Param param: params) {
                List<PerDay> perDays = contrastService.stayTime(testId, param.getId(), page);
                ret.put(String.valueOf(param.getId()), perDays);
            }

            return Responses.successResponse().addData("groups", ret);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    /**
     * 注意现在是没有算点击率的，算的是总点击数
     * @param testId 测试Id
     * @param page 页面url
     * @param btnId 点击元素id
     * @return Response
     */
    @RequestMapping(value = "/clickRatio", method = RequestMethod.GET)
    public Response clickRatio(@Param("testId") int testId, @Param("page") String page, @Param("buttonId") String btnId) {
        try {
            List<com.logmaster.domain.model.Param> params = abService.getColumnList(testId);

            HashMap<String, List<PerDay>> ret = new HashMap<>();

            for (com.logmaster.domain.model.Param param: params) {
                List<PerDay> perDays = contrastService.clickRatio(testId, param.getId(), page, btnId);
                ret.put(String.valueOf(param.getId()), perDays);
            }

            return Responses.successResponse().addData("groups", ret);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }


    @RequestMapping(value = "/pvCount", method = RequestMethod.GET)
    public Response pvCount(@Param("testId") int testId, @Param("page") String page) {
        try {
            List<com.logmaster.domain.model.Param> params = abService.getColumnList(testId);

            HashMap<String, List<PerDay>> ret = new HashMap<>();

            for (com.logmaster.domain.model.Param param: params) {
                List<PerDay> perDays = contrastService.pvCount(testId, param.getId(), page);
                ret.put(String.valueOf(param.getId()), perDays);
            }

            return Responses.successResponse().addData("groups", ret);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }
}
