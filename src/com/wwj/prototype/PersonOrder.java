package com.wwj.prototype;

public class PersonOrder implements IOrder {
	
	private String orderName;
	private int orderCount;
	
	
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	@Override
	public int getOrderCount() {
		return orderCount;
	}

	@Override
	public void setOrderCount(int orderCount) {
		this.orderCount=orderCount;
	}

	@Override
	public Prototype clonePrototype() {
		PersonOrder personOrder=new PersonOrder();
		personOrder.setOrderCount(orderCount);
		personOrder.setOrderName(orderName);
		return personOrder;
	}

}
