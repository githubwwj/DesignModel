package com.wwj.simplefactory;

public class SampleFactory {

	public static final int WOMAN = 1;
	public static final int MAN = 2;

	public static Human createHuman(int type) {
		Human human = null;
		switch (type) {
		case WOMAN:
			human = new Woman();
			break;
		case MAN:
			human = new Man();
			break;
		default:
			break;
		}
		return human;
	}
	
	public static Human createHuman(Class<?> clazz) {
		Human human = null;
		try {
			human=(Human) clazz.newInstance();
		} catch (InstantiationException e) {
			System.out.println("------无法创建对象-------");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("------没有创建对象的权限-------");
			e.printStackTrace();
		}
		return human;
	}

}
