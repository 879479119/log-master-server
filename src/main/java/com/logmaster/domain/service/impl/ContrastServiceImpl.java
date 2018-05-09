package com.logmaster.domain.service.impl;

import com.logmaster.domain.model.PerDay;
import com.logmaster.domain.service.AnalysisService;
import com.logmaster.domain.service.ContrastService;
import com.logmaster.mapper.slave.ContrastMapper;
import com.logmaster.mapper.slave.QueryMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("contrastService")
public class ContrastServiceImpl implements ContrastService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(ContrastServiceImpl.class);

    @Autowired
    ContrastMapper contrastMapper;

    @Autowired
    QueryMapper queryMapper;

    @Override
    public List<PerDay> stayTime(int testId, int paramId, String url) {
        return contrastMapper.stayTime(testId, paramId, url);
    }

    @Override
    public List<PerDay> clickRatio(int testId, int paramId, String url, String btnId) {
        List<PerDay> perDays = contrastMapper.clickRatio(testId, paramId, url, btnId);

//        List<Integer> pvCounts = queryMapper.pvCount(url);
//
//        perDays
        return contrastMapper.clickRatio(testId, paramId, url, btnId);
    }

    @Override
    public List<PerDay> pvCount(int testId, int paramId, String url) {
        return contrastMapper.pvCount(testId, paramId, url);
    }
}
