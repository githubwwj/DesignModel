package com.wwj.simplefactory;

public abstract class Test {

	public static void main(String[] args) {
		
//		Human human=SampleFactory.createHuman(SampleFactory.MAN);
//		human.talk();
		
		Human human=SampleFactory.createHuman(Woman.class);
		human.talk();
		
		//简单工厂的本质是: 工厂类通过传入参数创建不同类实例对象
		

	}

}
