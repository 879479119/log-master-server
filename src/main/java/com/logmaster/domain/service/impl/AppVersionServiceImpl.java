package com.logmaster.domain.service.impl;

import com.logmaster.application.constants.Constants;
import com.logmaster.domain.model.AppVersion;
import com.logmaster.domain.model.AppVersionView;
import com.logmaster.domain.model.Pagination;
import com.logmaster.domain.model.User;
import com.logmaster.domain.service.AppVersionService;
import com.logmaster.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wanglu
 * @Date: 2017/10/17.
 */

@Service("appService")
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appMapper;

    public List<AppVersionView> getList(AppVersionView appVersionView, Pagination pagination) {
        return appMapper.getAppVersionList(appVersionView,pagination);
    }

    public Integer getNums(AppVersionView appVersionView) {
        return appMapper.getAppVersionNums(appVersionView);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer add(AppVersionView appVersionView) {
        appMapper.addAppVersion(appVersionView);
        return appVersionView.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(AppVersionView appVersionView) {
        appMapper.editAppVersion(appVersionView);
    }

    @Override
    public AppVersionView getDetail(Integer id) {
        return appMapper.getAppVersionDetail(id);
    }
}
