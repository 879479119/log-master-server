package com.logmaster.api.controller;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.DataTypeEnum;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.enums.UserFavouriteEnum;
import com.logmaster.domain.model.LogDataView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import com.logmaster.domain.service.LogDataService;
import com.logmaster.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wanglu
 * @Description: 日志Controller
 * @Date: 2017/10/16.
 */
@RestController
@RequestMapping("/api/log")
public class LogDataController {

    private static Logger logger = LoggerFactory.getLogger(LogDataController.class);

    @Autowired
    LogDataService logDataService;

    /**
     * 查询日志列表.
     *
     * @param page        第几页
     * @param pageSize    每页大小
     * @param orderBy     排序字段
     * @param orderType   排序类型
     * @param logDataView 日志bean
     * @return 列表集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response getLogList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false, defaultValue = "mld.create_time") String orderBy,
                                 @RequestParam(required = false, defaultValue = "DESC") String orderType,
                                 LogDataView logDataView,
                                 HttpServletRequest request) {
        try {
            Pagination pagination = new Pagination((page - 1) * pageSize, pageSize, orderBy, orderType);
            QueryTransformUtil<LogDataView> queryTransformUtil = new QueryTransformUtil<>();
            queryTransformUtil.transformQuery(logDataView);
            List<LogDataView> logList = logDataService.getList(logDataView, pagination);
            Integer totalItems = logDataService.getNums(logDataView);
            return Responses.pagedResponse(totalItems, page, pageSize).addData("list", logList);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.LISTERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.LISTERROR.getErrorCode(), ErrorCodeEnum.LISTERROR.getErrorName());
        }
    }

    /**
     * 新增日志.
     *
     * @param logDataView 日志bean
     * @return 状态
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addLog(@RequestBody LogDataView logDataView, HttpServletRequest request) {
        try {
            Integer logId = logDataService.add(logDataView);
            return Responses.successResponse().addData("logId", logId);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.SAVEERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.SAVEERROR.getErrorCode(), ErrorCodeEnum.SAVEERROR.getErrorName());
        }
    }

    /**
     * 修改日志信息.
     *
     * @param logDataView 日志bean
     * @return 状态
     */

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response editLog(@RequestBody LogDataView logDataView, HttpServletRequest request) {
        try {
            logDataService.edit(logDataView);
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
            LogDataView logDataView = logDataService.getDetail(id);
            return Responses.successResponse().addData("detail", logDataView);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

}
