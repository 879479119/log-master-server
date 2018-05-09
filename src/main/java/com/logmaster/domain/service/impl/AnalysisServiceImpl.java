package com.logmaster.domain.service.impl;

import com.logmaster.domain.service.AnalysisService;
import com.logmaster.mapper.slave.QueryMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(AnalysisServiceImpl.class);

    @Autowired
    QueryMapper queryMapper;

    @Override
    public Integer addCount() {
        return queryMapper.addCount1();
    }

    @Override
    public Integer count() {
        return queryMapper.count();
    }

    @Override
    public Integer activeCount() {
        return queryMapper.activeCount();
    }

    @Override
    public List<Integer> lineActiveDay() {
        return queryMapper.lineActiveDay();
    }

    @Override
    public List<Integer> pvCount(String url) {
        return queryMapper.pvCount(url);
    }

    @Override
    public List<Integer> viewTime() {
        return queryMapper.viewTime();
    }

    @Override
    public List<Integer> enterCount() {
        return queryMapper.enterCount();
    }
}
