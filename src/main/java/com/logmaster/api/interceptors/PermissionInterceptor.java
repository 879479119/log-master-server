package com.logmaster.api.interceptors;

import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.domain.enums.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//import org.json.JSONObject;


/**
 * @author wanglu
 * @Description:
 * @Date: 2017/11/03.
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);

    ThreadLocal<Long> timeCount = new ThreadLocal<>();

    private static final String SERVER_START = "/service";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        timeCount.set(System.currentTimeMillis());
        request.setAttribute("startTime", System.currentTimeMillis());
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        //判断用户ID是否存在，不存在就跳转到登录界面
        if(session.getAttribute("userId") == null){
            log.info("没有登录哦");
            return authFailed(response);
        }else{
            session.setAttribute("userId", session.getAttribute("userId"));
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long callTime = System.currentTimeMillis() - timeCount.get();
        timeCount.remove();
        String callTimeStr = Long.toString(callTime) + " ms";
        String method = request.getMethod();
        String api = request.getRequestURI();
        String responseCode = Integer.toString(response.getStatus());
        String path = request.getQueryString();
        log.info(callTimeStr + "|" + method + "|" + api + "|" + responseCode + "|" + path);
    }

    private boolean authFailed(HttpServletResponse response) throws IOException {
        Response response1 = Responses.errorResponse(ErrorCodeEnum.TOKENERROE.getErrorCode(), ErrorCodeEnum.TOKENERROE.getErrorName());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(401);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append("{code: 0, status: \"error\"}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return false;
    }

}
