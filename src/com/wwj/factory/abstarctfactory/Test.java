package com.wwj.factory.abstarctfactory;

public class Test {

	public static void main(String[] args) {
		
		AbstractFactory abstractFactory=new NormalFactory();
		
		Vehicle vehicle=abstractFactory.createVehicle();
		vehicle.run();
		
		Weapon weapon=abstractFactory.createWeapon();
		weapon.shoot();

	}

}
