package com.logmaster.domain.model;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/19.
 */

public class LogBusinessView {

    private Integer id;

    private String name;

    List<Page> pageList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }
}
