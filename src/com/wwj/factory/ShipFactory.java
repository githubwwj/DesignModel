package com.wwj.factory;

public class ShipFactory extends VehicleFactory {

	Moveable create() {
		return new Ship();
	}

}
