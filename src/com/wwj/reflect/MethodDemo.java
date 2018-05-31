package com.wwj.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {

	static class Student {

		private String name;

		private void learn(String place, String course) {
			System.out.println(name+"这个学生在" + place + "学习" + course);

		}

		public void learn(int a, int b) {
			System.out.println(a + b);
		}

		public void learn() {
			System.out.println(name + "今天认真学习了");
		}

	}

	public static void main(String[] args) {

		// 1 获取类信息 获取类的类型信息
		Student student = new Student();
		student.name="李亮亮";
		student.learn("图书馆", "JAVA反射");

		Class clazz = student.getClass();
		try {
//			Field field=clazz.getField("name"); //只可以获取共有属性
			Field field=clazz.getDeclaredField("name");
			field.setAccessible(true); //设置可以访问私有属性的权限
			field.set(student, "wwj");
			
			// Method m = clazz.getMethod("learn", new Class[] {
			// String.class,String.class });
			// Method m = clazz.getMethod("learn", String.class,String.class);
			// //获取public 方法
			Method m = clazz.getDeclaredMethod("learn", String.class,
					String.class);
			

			m.setAccessible(true); // 可以调用私有的方法
			// m.invoke(student, "教室", "PHP");
			m.invoke(student, new String[] { "教室", "PHP" });

			// m=clazz.getDeclaredMethod("learn",null);
			// m.invoke(student, null);
			m = clazz.getDeclaredMethod("learn");
			m.invoke(student);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
