package com.jiangnanyidianyu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值,就是要导入到容器中的组件的全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.jiangnanyidianyu.bean.Blue","com.jiangnanyidianyu.bean.Yellow"};
    }
}
