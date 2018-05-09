package com.logmaster.mapper.slave;

import com.logmaster.domain.model.PerDay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContrastMapper {

    List<PerDay> stayTime(@Param("testId") int testId, @Param("paramId") int paramId, @Param("url") String url);

    List<PerDay> clickRatio(@Param("testId") int testId, @Param("paramId") int paramId, @Param("url") String url, @Param("btnId") String btnId);

    List<PerDay> pvCount(@Param("testId") int testId, @Param("paramId") int paramId, @Param("url") String url);

}
