package com.wxw.springboot_digester.domain.school;

import lombok.Data;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxiongwei
 * @date 2021/2/23 14:08
 * @Description
 */
@Data
@ObjectCreate(pattern = "school")
public class SchoolGroup {

    private List<Class> list = new ArrayList();

    @SetNext
    public void addNext(Class clazz) {
        this.list.add(clazz);
    }

}
