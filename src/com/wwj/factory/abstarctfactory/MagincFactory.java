package com.wwj.factory.abstarctfactory;

public class MagincFactory extends AbstractFactory {

	public Vehicle createVehicle() {

		return new Broom();
	}

	public Weapon createWeapon() {

		return new MagicStick();
	}

	public Food createFood() {
		
		return new Mushroom();
	}

}
