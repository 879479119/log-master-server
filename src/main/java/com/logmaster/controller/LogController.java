package com.logmaster.controller;

import com.logmaster.entity.Resp;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/login")
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public Resp loginPost(
            @RequestBody String name,
            @RequestBody String password) {

        logger.info(name + password);

        return new Resp(0, "ok");
    }
}
