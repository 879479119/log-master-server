package com.logmaster.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.logmaster.api.response.base.Response;
import com.logmaster.api.response.base.Responses;
import com.logmaster.domain.model.LogType;
import com.logmaster.domain.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class LogTypeController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    TypeService typeService;

    @RequestMapping("")
    public Response getAllType () throws JsonProcessingException {

        List<LogType> logTypes = typeService.getTypeList();

        return Responses.successResponse().addData("logTypes", logTypes);
    }
}
