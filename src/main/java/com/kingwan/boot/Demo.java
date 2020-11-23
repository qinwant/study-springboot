package com.kingwan.boot;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kingwan on 2020/11/22.
 * 说明：
 */
@Controller
public class Demo {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BootApplication.class);

    @RequestMapping("string")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String helloString(){
        log.trace("trace");
        log.debug("debug");
        log.warn("warn");
        log.info("info");
        log.error("error");
        return "Hello Spring Boot";
    }
}
