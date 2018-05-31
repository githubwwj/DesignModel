package com.wwj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo {

	public static void main(String[] args) {

		Class c1 = int.class;
		Class c2 = Integer.class;
		Class c3 = void.class;

		String a = "s";
		// printClassMethodInfo(a);
		//
		// System.out.println(c1.getName() + "-----c2=" + c2.getName() +
		// "----c3="
		// + c3.getName());

		// printClassFieldInfo(a);
		printClassConstructInfo(a);

	}

	public static void printClassMethodInfo(Object obj) {
		// 获取类的信息 获取类的类类型
		Class clazz = obj.getClass();

		// 一个成员函数就是一个Method对象
		// Method[] methods = clazz.getMethods(); // 获取所有的public 方法
		Method[] methods = clazz.getDeclaredMethods();

		for (Method m : methods) {
			Class returnType = m.getReturnType(); // 后去返回值的类的类类型
			// 1 打印返回值的类的类类型
			System.out.print(returnType.getName() + " ");

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

	public static void printClassFieldInfo(Object obj) {
		// 1 获取类的信息 获取类的类类型
		Class clazz = obj.getClass();

		// 属性也是对象
		Field[] fields = clazz.getFields(); // 获取public属性

		// Field[] fields = clazz.getDeclaredFields(); // 获取所有属性

		for (Field f : fields) {
			Class cField = f.getType(); // 获取属性 的 类类型
			System.out.println(cField.getName() + " " + f.getName());
		}

	}

	public static void printClassConstructInfo(Object obj) {
		// 1 获取类的信息 获取类的类类型
		Class clazz = obj.getClass();
		// 构造函数也是一个对象
		// Constructor[] constructors = clazz.getConstructors(); // 获取public构造函数
		
		Constructor[] constructors = clazz.getDeclaredConstructors(); // 获取所有的构造函数
		for (Constructor c : constructors) {
			System.out.print(c.getName() +"(");
			
			Class[] cparams=c.getParameterTypes();  //参数列表 也是 类类型
			for(int i=0;i<cparams.length;i++){
				System.out.print(cparams[i].getName());
				if(i+1!=cparams.length){
					System.out.print(",");
				}
			}
			System.out.println(")");
		}

	}

}
