package com.logmaster.domain.service.impl;
import com.logmaster.domain.model.*;
import com.logmaster.domain.service.LogDataService;
import com.logmaster.mapper.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglu
 * @Date: 2017/10/17.
 */

@Service("logDataService")
public class LogDataServiceImpl implements LogDataService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(LogDataServiceImpl.class);

    @Autowired
    LogDataMapper logDataMapper;

    private static final Integer LOG_KEY_ID = 1;

    private static final Boolean LOG_KEY_ID_REQUIRED = true;

    @Override
    public List<LogDataView> getList(LogDataView bean, Pagination pagination) {
        return null;
    }

    @Override
    public Integer getNums(LogDataView bean) {
        return null;
    }

    @Override
    public Integer add(LogDataView bean) {
        return null;
    }

    @Override
    public void edit(LogDataView bean) {

    }

    @Override
    public LogDataView getDetail(Integer id) {
        return null;
    }

    @Override
    public LogDataView getDetail(Integer id, User user) {
        return logDataMapper.getLogDataView(id, user);
    }

}
