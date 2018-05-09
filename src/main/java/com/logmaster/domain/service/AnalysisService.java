package com.logmaster.domain.service;


import java.util.List;

public interface AnalysisService {

    /**
     * 新增用户数
     * @return 用户数
     */
    Integer addCount();

    /**
     * 所有用户的数量
     * @return 数量
     */
    Integer count();


    Integer activeCount();


    List<Integer> lineActiveDay();


    List<Integer> pvCount(String url);


    List<Integer> viewTime();

    List<Integer> enterCount();


}
