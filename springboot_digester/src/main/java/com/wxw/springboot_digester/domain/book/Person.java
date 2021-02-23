package com.wxw.springboot_digester.domain.book;

import lombok.Data;
import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;

/**
 * @author wuxiongwei
 * @date 2021/2/23 14:34
 * @Description
 */
@Data
@ObjectCreate(pattern = "books/book/person")
public class Person {

    @BeanPropertySetter(pattern = "books/book/person")
    private String name;

}
