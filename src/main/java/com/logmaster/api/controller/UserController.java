package com.logmaster.api.controller;

import com.google.common.collect.Lists;
import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.api.response.UserResponse;
import com.logmaster.application.utils.QueryTransformUtil;
import com.logmaster.application.utils.Util;
import com.logmaster.domain.enums.ErrorCodeEnum;
import com.logmaster.domain.model.*;
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
import java.util.List;


/**
 * @author wanglu
 * @Description: 用户Controller
 * @Date: 2017/11/03.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private static class UserRequest {
        private String userName;
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    @Autowired
    UserService userService;

    /**
     * 获取用户列表.
     *
     * @param page     页码
     * @param pageSize 一页显示个数
     * @return Response
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response getUserList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                User user) {
        try {
            Pagination pagination = new Pagination((page - 1) * pageSize, pageSize);
            List<User> userList = userService.getUserList(pagination);
            List<UserResponse> userResponseList = Lists.newArrayList();
            userList.forEach(userInfo -> userResponseList.add(new UserResponse(userInfo)));
            Integer totalItems = userService.getUserNums();
            return Responses.pagedResponse(totalItems, page, pageSize).addData("users", userResponseList);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.LISTERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.LISTERROR.getErrorCode(), ErrorCodeEnum.LISTERROR.getErrorName());
        }
    }

    /**
     * 获取当前登录用户信息.
     *
     * @return Response
     */
    @RequestMapping("/me")
    public Response getUserDetail(HttpServletRequest request) throws IOException {
        try {
            HttpSession httpSession = request.getSession();
            User user = userService.getUserById((Integer) httpSession.getAttribute("userId"));
            return Responses.successResponse().addData("user", user);
        } catch (Exception e) {
            logger.error(ErrorCodeEnum.DETAILERROR.getErrorName() + Util.getExceptionMessage(e));
            return Responses.errorResponse(ErrorCodeEnum.DETAILERROR.getErrorCode(), ErrorCodeEnum.DETAILERROR.getErrorName());
        }
    }

    /**
     * 登录
     * @return Response
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Resp loginPost(@RequestBody UserRequest userRequest, HttpServletRequest request) {

        Integer id = userService.getLoginId(userRequest.getUserName(), userRequest.getPassword());

        if (id != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            return new Resp(0, "ok");
        } else {
            return new Resp(1, "error");
        }
    }
}
