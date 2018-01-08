package com.wwj.factory.abstarctfactory;

public abstract class AbstractFactory {
	
	public abstract Vehicle createVehicle();
	
	public abstract Weapon createWeapon(); 
	
	//产品品种
	public abstract Food createFood();

}
