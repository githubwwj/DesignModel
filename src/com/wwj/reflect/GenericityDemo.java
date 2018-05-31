package com.wwj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GenericityDemo {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList<>();

		ArrayList<String> al2 = new ArrayList<>();

		al2.add("abc");
		// al2.add(100);

		// 泛型本质防止输入错误,只在编译阶段有效
		// 绕过编译阶段,泛型就无效了

		Class c1 = al1.getClass();
		Class c2 = al2.getClass();

		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(al2, 100);

			System.out.println(al2.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(Object s:al2){
//			System.out.println();
//		}

		System.out.println(c1 == c2);

	}

}
