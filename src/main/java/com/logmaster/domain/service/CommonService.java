package com.logmaster.domain.service;

import com.logmaster.domain.model.App;
import com.logmaster.domain.model.AppPlatform;
import com.logmaster.domain.model.AppVersion;

import java.util.List;

public interface CommonService {
    public List<App> getAppList();

    public List<AppVersion> getAppSubVersions(App app);

    public List<AppPlatform> getPlatform ();
}
