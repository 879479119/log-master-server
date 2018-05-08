package com.logmaster.domain.service.impl;

import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.Param;
import com.logmaster.domain.service.ABService;
import com.logmaster.mapper.master.ABMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wanglu
 * @Date: 2017/10/17.
 */

@Service("abService")
public class ABServiceImpl implements ABService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(ABServiceImpl.class);

    @Autowired
    ABMapper abMapper;

    private static final Integer LOG_KEY_ID = 1;

    private static final Boolean LOG_KEY_ID_REQUIRED = true;

    @Override
    public List<ABTestView> getList(ABTestView bean, Pagination pagination) {
        return abMapper.getLogDataList(bean, pagination);
    }

    @Override
    public Integer getNums(ABTestView bean) {
        return abMapper.getLogDataNums(bean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(ABTestView bean) {
        // 在mine中添加主体部分
        abMapper.addLogData(bean);
        final int id = bean.getId();
        // 在column中添加columns
        List<Param> params = bean.getParams();

        for (Param param : params) {
            param.setParent(id);
        }
        if (!params.isEmpty()) {
            abMapper.addColumnData(bean.getParams());
        }

        return id;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(ABTestView bean) {
        abMapper.editLogData(bean);
        final List<Param> params = bean.getParams();
        abMapper.delColumnData(bean.getId());

        if (!params.isEmpty()) {
            abMapper.addColumnData(params);
        }
    }

    @Override
    public ABTestView getDetail(Integer id) {
        return abMapper.getABTestView(id);
    }

}
