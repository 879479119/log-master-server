package com.logmaster.api.controller;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.AppVersion;
import com.logmaster.domain.model.AppVersionView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import com.logmaster.domain.service.AppVersionService;
import com.logmaster.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wanglu
 * @Description: app版本Controller
 * @Date: 2017/10/17.
 */
@RestController
@RequestMapping("/api/appversion")
public class AppVersionController {

    private static Logger logger = LoggerFactory.getLogger(AppVersionController.class);

    @Autowired
    AppVersionService appService;

    /**
     * 分页查询.
     * @param page 页码
     * @param pageSize 每页大小
     * @param orderBy 排序字段
     * @param orderType 排序类型
     * @param appVersionView app版本bean
     * @return json
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response getAppVersionList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false, defaultValue = "create_time") String orderBy,
                                      @RequestParam(required = false, defaultValue = "DESC") String orderType,
                                      AppVersionView appVersionView,
                                      HttpServletRequest request) {
        try {
            Pagination pagination = new Pagination((page - 1) * pageSize, pageSize, orderBy, orderType);
            QueryTransformUtil<AppVersionView> queryTransformUtil = new QueryTransformUtil<>();
            queryTransformUtil.transformQuery(appVersionView);
            List<AppVersionView> appVersionList = appService.getList(appVersionView,pagination);
            Integer totalItems = appService.getNums(appVersionView);
            return Responses.pagedResponse(totalItems, page, pageSize).addData("list", appVersionList);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.LISTERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.LISTERROR.getErrorCode(), ErrorCodeEnum.LISTERROR.getErrorName());
        }
    }

}
