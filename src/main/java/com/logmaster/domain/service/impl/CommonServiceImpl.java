package com.logmaster.domain.service.impl;

import com.logmaster.domain.model.App;
import com.logmaster.domain.model.AppPlatform;
import com.logmaster.domain.model.AppVersion;
import com.logmaster.domain.service.CommonService;
import com.logmaster.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public List<App> getAppList() {
        return commonMapper.getAppList();
    }

    @Override
    public List<AppVersion> getAppSubVersions(App app) {
        return commonMapper.getVersionList(app.getId());
    }

    @Override
    public List<AppPlatform> getPlatform() {
        return commonMapper.getPlatformList();
    }
}
