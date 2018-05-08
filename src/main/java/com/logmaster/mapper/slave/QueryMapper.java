package com.logmaster.mapper.slave;

import com.logmaster.domain.model.ABTestView;
import com.logmaster.domain.model.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryMapper {

    Integer addCount1();

    Integer count();

    Integer activeCount();

    List<Integer> lineActiveDay();

    List<Integer> pvCount();

    List<Integer> viewTime();

    List<Integer> enterCount();

}
