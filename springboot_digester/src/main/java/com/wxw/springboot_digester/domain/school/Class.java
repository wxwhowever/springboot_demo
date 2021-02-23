package com.wxw.springboot_digester.domain.school;

import lombok.Data;
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
//当碰到 xml 中的 school/class 标签时，创建一个对象
@ObjectCreate(pattern = "school/class")
public class Class {
    /**
     * SetProperty 适用于接收如下格式
     *  <class code="001" Title="一年一班">
     */
    @SetProperty(pattern = "school/class")
    private String code;

    /**
     * <class code="001" Title="一年一班">
     *   如果 xml 中标签的属性名称与对象属性名称不一致，可以使用 attributeName ，标识当前这个对象属性 title 接收 xml 标签的 Title 属性
     */
    @SetProperty(pattern = "school/class",attributeName = "Title")
    private String title;

    private Teacher teacher = new Teacher();

    private List<Student> studentList = new ArrayList<>();



    // 当碰到 school/class 标签下的 student 标签的处理
    @SetNext
    public void addNext(Student student) {
        this.studentList.add(student);
    }

    // 当碰到 school/class 标签下的 teacher 标签的处理
    @SetNext
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
