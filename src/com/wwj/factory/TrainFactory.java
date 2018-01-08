package com.wwj.factory;

public class TrainFactory extends VehicleFactory {

	Moveable create() {
		return new Train();
	}

}
