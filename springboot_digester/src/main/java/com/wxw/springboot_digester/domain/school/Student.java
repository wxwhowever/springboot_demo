package com.wxw.springboot_digester.domain.school;

import lombok.Data;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetProperty;

/**
 * @author wuxiongwei
 * @date 2021/2/23 14:10
 * @Description
 */
@Data
@ObjectCreate(pattern = "school/class/student")
public class Student {

    @SetProperty(pattern = "school/class/student")
    private String code;

    @SetProperty(pattern = "school/class/student")
    private String name;

}
