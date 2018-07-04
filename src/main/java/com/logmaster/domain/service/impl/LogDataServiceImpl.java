package com.logmaster.domain.service.impl;
import com.logmaster.domain.model.*;
import com.logmaster.domain.service.LogDataService;
import com.logmaster.mapper.master.LogDataMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return logDataMapper.getLogDataList(bean, pagination);
    }

    @Override
    public Integer getNums(LogDataView bean) {
        return logDataMapper.getLogDataNums(bean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(LogDataView bean) {
        // 在mine中添加主体部分
        logDataMapper.addLogData(bean);
        final int id = bean.getId();
        // 在column中添加columns

        for (Column column : bean.getColumns()) {
            column.setParent(id);
        }
        logDataMapper.addColumnData(bean.getColumns(), bean.getId());

        return id;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(LogDataView bean) {
        logDataMapper.editLogData(bean);
        final List<Column> columns = bean.getColumns();
        logDataMapper.delColumnData(bean.getId());

        if (!columns.isEmpty()) {
            logDataMapper.addColumnData(columns, bean.getId());
        }
    }

    @Override
    public LogDataView getDetail(Integer id) {
        return logDataMapper.getLogDataView(id);
    }

    @Override
    public void delete(Integer id) {
        logDataMapper.delete(id);
        logDataMapper.delColumnData(id);
    }
}
