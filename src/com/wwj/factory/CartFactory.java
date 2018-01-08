package com.wwj.factory;

public class CartFactory extends VehicleFactory{
	

	Moveable create() {
		return new Cart();
	}

}
