package com.wxw.springboot_digester.demo;

import com.wxw.springboot_digester.domain.school.Class;
import com.wxw.springboot_digester.domain.school.SchoolGroup;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;


/**
 * @author wuxiongwei
 * @date 2021/2/23 14:21
 * @Description
 */
public class SchoolDigester {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());



    public static void main(String[] args) {

        // 定义要解析的 XML 的路径
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:school.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Digester digester = DigesterLoader.newLoader(new FromAnnotationsRuleModule() {
            @Override
            protected void configureRules() {
                // 这里只添加HolidayInfoXmlGroup即可
                bindRulesFrom(SchoolGroup.class);
            }
        }).newDigester();

        try {
            SchoolGroup parse = digester.parse(file);
            for (Class aClass : parse.getList()) {
                LOGGER.info("学校xml解析信息如下"+aClass.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
            LOGGER.info("load error：",e.getMessage());
        }
    }
}
