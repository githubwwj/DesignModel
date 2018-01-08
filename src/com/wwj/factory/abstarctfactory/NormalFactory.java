package com.wwj.factory.abstarctfactory;

public class NormalFactory extends AbstractFactory {

	public Vehicle createVehicle() {

		return new AirShip();
	}

	public Weapon createWeapon() {

		return new Handgun();
	}

}
