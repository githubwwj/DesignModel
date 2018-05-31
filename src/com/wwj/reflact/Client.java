package com.wwj.reflact;

public class Client {

	public static void main(String[] args) {

		// 创建Foo对象(创建类对象)
		Foo foo = new Foo();

		
		//得的类类型对象 第一种写法
		Class<?> cs1 = Foo.class;
		
		//得的类类型对象 第二种写法
		Class<?> cs2=foo.getClass();
		
		//因为类类型对象只可能创建一次
		System.out.println(cs1==cs2);
		
		try {
			//得的类类型对象 第三种写法
			Class<?> cs3=Class.forName("com.wwj.reflact.Foo");
			
			
			System.out.println(cs1==cs3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Foo {

}
