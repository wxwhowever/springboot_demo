package com.wxw.springboot_eventlistener.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

/**
 * @author wuxiongwei
 * @date 2021/3/2 10:02
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ApplicationEventPublisher applicationEventPublisher;

    public TestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping("/addStudent")
    public String test(@RequestBody Student student){
        LOGGER.info("新增的学生信息："+student.toString());
        applicationEventPublisher.publishEvent(new StudentEvent<>(student));
        return "success";
    }

}
