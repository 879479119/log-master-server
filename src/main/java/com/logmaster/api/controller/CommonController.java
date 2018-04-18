package com.logmaster.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.api.response.UserResponse;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.*;
import com.logmaster.domain.service.CommonService;
import com.logmaster.domain.service.UserService;
import com.logmaster.entity.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    CommonService commonService;

    @RequestMapping("")
    public Response common () throws JsonProcessingException {
        List<App> appList = commonService.getAppList();
        List<AppPlatform> appPlatforms = commonService.getPlatform();
        List<AppVersion> appVersions = new ArrayList<>();
        for (App app : appList) {
            appVersions.addAll(commonService.getAppSubVersions(app));
        }

        return Responses.successResponse()
                .addData("appList", appList)
                .addData("appPlatforms", appPlatforms)
                .addData("appVersions", appVersions);
    }

}
