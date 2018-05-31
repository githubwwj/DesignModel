package com.wwj.reflect;

public class Client {

	public static void main(String[] args) {
		
		/**
		 * 万事万物皆对象
		 * 类也是对象
		 * 有两种不是面向对象的?
		 * static 基本数据类型
		 * int Integer
		 * float Float
		 * 
		 * 类的类对象在程序怎么表示？
		 */
		
		Student student=new Student();
		student.print();
		
		//类的类对象第一种表示方式,默认隐含了静态变量
		Class<Student> c1=Student.class;
		
		//第二种表示方式
		Class<?> c2= student.getClass();
		
		//官网中  c1 or c2  表示Student类的类类型 
		System.out.println(c1==c2);
		
		
		//第三种表示方式
		try {
			Class c3=Class.forName("com.wwj.reflect.Student");
			System.out.println(c1==c3);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
class Student{
	void print(){
		System.out.println("我是一名学生");
	}
}
