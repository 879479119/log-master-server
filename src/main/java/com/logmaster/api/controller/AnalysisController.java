package com.logmaster.api.controller;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.service.ABService;
import com.logmaster.domain.service.AnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private static Logger logger = LoggerFactory.getLogger(AnalysisController.class);

    @Autowired
    AnalysisService analysisService;

    @RequestMapping(value = "/addCount", method = RequestMethod.GET)
    public Response addCount() {
        try {
            Integer addCount = analysisService.addCount();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Response count() {
        try {
            Integer addCount = analysisService.count();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/activeCount", method = RequestMethod.GET)
    public Response activeCount() {
        try {
            Integer addCount = analysisService.activeCount();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/lineActiveDay", method = RequestMethod.GET)
    public Response lineActiveDay() {
        try {
            List<Integer> addCount = analysisService.lineActiveDay();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/pvCount", method = RequestMethod.GET)
    public Response pvCount() {
        try {
            List<Integer> addCount = analysisService.pvCount(null);
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/viewTime", method = RequestMethod.GET)
    public Response viewTime() {
        try {
            List<Integer> addCount = analysisService.viewTime();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    @RequestMapping(value = "/enterCount", method = RequestMethod.GET)
    public Response enterCount() {
        try {
            List<Integer> addCount = analysisService.enterCount();
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }
}
