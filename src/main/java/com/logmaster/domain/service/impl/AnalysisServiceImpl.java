package com.logmaster.domain.service.impl;

import com.logmaster.domain.service.AnalysisService;
import com.logmaster.mapper.slave.QueryMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(AnalysisServiceImpl.class);

    @Autowired
    QueryMapper queryMapper;

    @Override
    public Integer addCount() {
        return queryMapper.addCount1();
    }
}
