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
import com.logmaster.domain.service.ABService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/hybrid")
public class HybridController {

    private static Logger logger = LoggerFactory.getLogger(HybridController.class);

    @Autowired
    ABService abService;

    @RequestMapping("/abInfo")
    public Response getAbInfo (
            @RequestParam("name") String userName,
            @RequestParam("app") int app,
            @RequestParam("platform") int platform,
            @RequestParam("version") int version,

            ABTestView abTestView) throws JsonProcessingException {
        logger.info(String.valueOf(userName.hashCode()));

        String userHash = String.valueOf(userName.hashCode());

        // 筛选现在正在进行的测试
        abTestView.setStartTime(new Date());
        abTestView.setEndTime(new Date());

        // 筛选当前应用符合的测试用例

        abTestView.setVersionId(version);
        abTestView.setPlatformId(platform);
        abTestView.setStatus(1);

        logger.info(platform + "  " + version + "  " + app);

        class ABTest {
            private int testId;
            private int paramsId;
            private String params;

            public int getTestId() {
                return testId;
            }

            public void setTestId(int testId) {
                this.testId = testId;
            }

            public int getParamsId() {
                return paramsId;
            }

            public void setParamsId(int paramsId) {
                this.paramsId = paramsId;
            }

            public String getParams() {
                return params;
            }

            public void setParams(String params) {
                this.params = params;
            }
        }

        // 应用于此版本，这段时间在工作的AB测试
        List<ABTestView> abTestViews = abService.getList(abTestView, new Pagination(0, 999));

        List<ABTest> abTests = new ArrayList<>();

        for (ABTestView abTestView1 : abTestViews) {
            String hash = abTestView1.getHash();
            if (hash == null) { continue; }
            String hashs[] = hash.split(",");

            for (int i = 0; i < hashs.length; i++) {
                if (userHash.endsWith(hashs[i])) {
                    List<Param> params = abTestView1.getParams();
                    // 如果参与进了这次测试
                    // 那么根据存的随机数看看他是在第几位 决定他拿到哪些参数
                    if (params.size() == 0) { continue; }
                    int count = hashs.length / params.size();
                    int group = i / count;
                    ABTest abTest = new ABTest();
                    abTest.setTestId(abTestView1.getId());
                    abTest.setParamsId(params.get(group).getId());
                    abTest.setParams(params.get(group).getConfig());
                    abTests.add(abTest);
                    break;
                }
            }
        }

        return Responses.successResponse().addData("detail", abTests);
    }

}
