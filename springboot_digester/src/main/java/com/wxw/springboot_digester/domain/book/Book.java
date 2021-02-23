package com.wxw.springboot_digester.domain.book;

import lombok.Data;
import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;
import org.apache.commons.digester3.annotations.rules.SetProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxiongwei
 * @date 2021/2/23 14:07
 * @Description
 */
@Data
@ObjectCreate(pattern = "books/book")
public class Book {

    /**
     * 适用于如下这种 xml 标签格式
     *    <book>
     *         <title>西游记</title>
     *     </book>
     */
    @BeanPropertySetter(pattern = "books/book/title")
    private String title;

    @BeanPropertySetter(pattern = "books/book/description")
    private String description;


    private List<Person> personList = new ArrayList<>();

    @SetNext
    public void addNext(Person clazz) {
        this.personList.add(clazz);
    }
}
