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
            logger.info(String.valueOf(addCount));
            return Responses.successResponse().addData("count", addCount);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }
}
