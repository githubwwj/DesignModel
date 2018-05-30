package com.wwj.prototype;

public class CompanyOrder implements IOrder {

	private String orderName;
	private int orderCount;

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public void setOrderCount(int orderCount) {
		this.orderCount=orderCount;
	}

	@Override
	public int getOrderCount() {
		return orderCount;
	}

	@Override
	public Prototype clonePrototype() {
		CompanyOrder companyOrder=new CompanyOrder();
		companyOrder.setOrderName(orderName);
		companyOrder.setOrderCount(orderCount);
		return companyOrder;
	}

}
