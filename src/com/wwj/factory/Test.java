package com.wwj.factory;

public class Test {

	public static void main(String[] args) {
		
		VehicleFactory vehicleFactory=new PlaneFactory();
		Moveable cart=vehicleFactory.create();
		cart.run();
		

	}

}
