package com.logmaster.mapper;

import com.logmaster.domain.model.App;
import com.logmaster.domain.model.AppPlatform;
import com.logmaster.domain.model.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonMapper {
    List<App> getAppList();

    List<AppVersion> getVersionList (@Param("id") Integer id);

    List<AppPlatform> getPlatformList ();
}
