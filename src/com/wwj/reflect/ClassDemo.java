package com.wwj.reflect;

import java.lang.reflect.Method;

public class ClassDemo {

	public static void main(String[] args) {

		
		Class c1=int.class;
		Class c2=Integer.class;
		Class c3=void.class;
		
		
		
		Integer a = 10;
		printClassMethodInfo(a);
		
		System.out.println(c1.getName()+"-----c2="+c2.getName()+"----c3="+c3.getName());

	}

	public static void printClassMethodInfo(Object obj) {
		// 获取类的信息 获取类的类类型
		Class clazz = obj.getClass();

		// 一个成员函数就是一个Method对象
		Method[] methods = clazz.getMethods(); // 获取所有的public 方法

		for (Method m : methods) {
			Class returnType = m.getReturnType(); // 后去返回值的类的类类型
			// 1 打印返回值的类的类类型
			System.out.print(returnType.getName()+" ");

			// 2 打印方法名
			System.out.print(m.getName() + "(");

			// 3 打印方法的参数列表 参数列表的类型的类类型
			Class[] params = m.getParameterTypes();

			for (int i = 0; i < params.length; i++) {
				System.out.print(params[i].getName());
				if (i + 1 != params.length) {
					System.out.print(",");
				}
			}

			System.out.println(")");
		}

	}

}
