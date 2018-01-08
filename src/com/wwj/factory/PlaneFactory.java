package com.wwj.factory;

public class PlaneFactory extends VehicleFactory{
	
	Moveable create(){
		return new Plane();
	}

}
