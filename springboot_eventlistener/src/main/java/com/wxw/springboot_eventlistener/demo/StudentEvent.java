package com.wxw.springboot_eventlistener.demo;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author wuxiongwei
 * @date 2021/3/2 9:58
 * @Description
 */
public class StudentEvent<T> extends ApplicationEvent {
    private  T data;

    public StudentEvent(T source) {
        super(source);
        this.data = source;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
