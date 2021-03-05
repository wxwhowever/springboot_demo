package com.wxw.springboot_eventlistener.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * @author wuxiongwei
 * @date 2021/3/2 10:48
 * @Description
 */
@Component
public class StudentEventListener implements ApplicationListener<StudentEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void onApplicationEvent(StudentEvent studentEvent) {
        LOGGER.info("监听到的信息："+studentEvent.getData());
    }


    @EventListener
    @Order(1)
    public void addStudentListener1(StudentEvent<Student> studentTestEvent){
        LOGGER.info("监听到的信息1："+studentTestEvent.getData());
    }

    @EventListener
    @Order(3)
    public void addStudentListener3(StudentEvent<Student> studentTestEvent){
        LOGGER.info("监听到的信息3："+studentTestEvent.getData());
    }

    @EventListener
    @Order(2)
    public void addStudentListener2(StudentEvent<Student> studentTestEvent){
        LOGGER.info("监听到的信息2："+studentTestEvent.getData());
    }
}
