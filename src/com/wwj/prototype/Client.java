package com.wwj.prototype;

public class Client {

	public static void main(String[] args) {
		DealOrderFactory dealOrderFactory=new DealOrderFactory();
		
		CompanyOrder personOrder=new CompanyOrder();
		personOrder.setOrderCount(3500);
		personOrder.setOrderName("女朋友");
		
		dealOrderFactory.dealOrder(personOrder);
		

	}

}
