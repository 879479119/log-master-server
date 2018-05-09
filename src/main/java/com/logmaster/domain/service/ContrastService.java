package com.logmaster.domain.service;


import com.logmaster.domain.model.PerDay;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContrastService {

    /**
     * 新增用户数
     * @return 用户数
     */
    List<PerDay> stayTime(int testId, int paramId, String url);

    List<PerDay> clickRatio(int testId, int paramId, String url, String btnId);


    List<PerDay> pvCount(int testId, int paramId, String url);
}
