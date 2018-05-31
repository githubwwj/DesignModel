package com.wwj.reflect;

public class Client {

	public static void main(String[] args) {

		Student student = new Student();
		student.print();

		// class 也是对象
		// 类也是实例对象,称为类的类类型,它是java.lang.Class
		Class c1 = Student.class;

		Class c2 = student.getClass();

		// 官网中 c1 or c2 称为 类类型,它们都表示同一个类的类实例对象
		System.out.println(c1 == c2);

		try {
			Class c3 = Class.forName("com.wwj.reflect.Student");

			System.out.println(c1 == c3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

class Student {
	void print() {
		System.out.println("我是一名学生");
	}
}
