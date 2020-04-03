package com.learning.handler;

import com.learning.annotation.Strategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 16:20
 **/
@Component
public class MyBeanHandlerProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targeClass = bean.getClass();
        Field[] fields = targeClass.getDeclaredFields();
        for (Field field: fields ) {
            if (field.isAnnotationPresent(Strategy.class)) {  //判断属性是否是自定义注解@MyAnnotation
//                if(!field.getType().isInterface()) {  //加自定义注解的属性必须是接口类型（这样才可能出现多个不同的实例bean)
//                    throw new BeanCreationException("MyAnnotation field must be declared an interface");
//                } else {
                    try {
                        //为属性赋值
                        this.hanldMyAnnotation(field, bean, field.getType());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
//                }
            }
        }
        return bean;
    }

    private void hanldMyAnnotation(Field field, Object bean, Class type) throws IllegalAccessException {
        //获取所有该属性接口的实例bean
        Map<String,Object> beans = this.applicationContext.getBeansOfType(type);
        //设置该域可设置修改
        field.setAccessible(true);
        //获取注解@MyAnnotation中配置的value值
//        String injectVal = field.getAnnotation(Strategy.class).value();
        String typeName = field.getType().getName();
        //将找到的实例赋值给属性域
        field.set(bean,beans.get(typeName));

    }

}
