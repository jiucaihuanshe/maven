package practice.com.project.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 注解：
 * 1）是java中的一种元数据，用于描述java对象
 * 2）本质上也是一个类
 * @Retention 表示自己定义的注册何时有效
 * @Target 表示自己定义的注解应用在哪里
 */
@Retention(RetentionPolicy.RUNTIME)//表示自己定义的注解在运行时有效
@Target(ElementType.METHOD)//表示自己定义的注解应用在方法上面
public @interface Permission {
	
}
