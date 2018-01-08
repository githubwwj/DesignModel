package com.wwj.factory.abstarctfactory;

public class Test {

	public static void main(String[] args) {
		
		
		//普通工厂系列   new NormalFactory()
		//魔法工厂系统   new MagincFactory()
		AbstractFactory abstractFactory=new NormalFactory();
		
		
		Vehicle vehicle=abstractFactory.createVehicle();
		vehicle.run();
		
		Weapon weapon=abstractFactory.createWeapon();
		weapon.shoot();

		Food food=abstractFactory.createFood();
		food.eatSomething();
		
		//抽象工厂缺点添加新品种有点麻烦,优点更换系统产品很爽
		//普通工厂优点创建产品很容易,每创建一个产品,要创建一个产品工厂,导致产品工厂泛滥
	}

}
