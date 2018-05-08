package com.logmaster.domain.service.impl;

import com.logmaster.domain.model.LogType;
import com.logmaster.domain.service.TypeService;
import com.logmaster.mapper.master.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<LogType> getTypeList() {
        return typeMapper.getTypeList();
    }
}
