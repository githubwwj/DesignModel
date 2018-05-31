package com.wwj.annotation;

import java.lang.reflect.Method;


public class Client {

	public static void main(String[] args) {

		// Student student=new Student();
		// student.sing();

		Class<?> clazz = Student.class;

		boolean cp = clazz.isAnnotationPresent(Description.class);
		if (cp) {
			Description description = (Description) clazz
					.getAnnotation(Description.class);
//			System.out.println(description.name() + "--" + description.age());
			System.out.println(description.value());
		}
		
		try {
			Method m=clazz.getMethod("talk");
			boolean md=m.isAnnotationPresent(Description.class);
			if(md){
				Description description=m.getAnnotation(Description.class);
//				System.out.println("---"+description.name()+"-----"+description.age());
				System.out.println(description.value());
			}
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		

	}

}
