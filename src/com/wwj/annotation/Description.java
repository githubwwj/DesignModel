package com.wwj.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @interface 定义了一个注解
@Target({ElementType.METHOD,ElementType.TYPE})  //定义作用域在方法上和类,接口上
@Retention(RetentionPolicy.RUNTIME) //生命周期
@Inherited  //继承只作用域类上,不会作用到接口上,不会作用于方法上
@Documented //生成文档的时候会有助解
public @interface Description {
	
//	String name();
//	
//	int age() default 0;
	//当注解没有成员的时候成为表示注解
	
	//当注解只有一个成员的时候,它的默认值是value
	String value();

}
