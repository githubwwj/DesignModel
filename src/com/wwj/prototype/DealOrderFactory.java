package com.wwj.prototype;

public class DealOrderFactory {

	public void dealOrder(IOrder order) {
		int orderCount = order.getOrderCount();
		while (orderCount > 0) {
			// if(order instanceof PersonOrder){
			// PersonOrder personOrder = (PersonOrder) order;
			// System.out.println("原来订单="+personOrder.hashCode());
			//
			// PersonOrder newOrder = new PersonOrder();
			// newOrder.setOrderCount(orderCount > 1000 ? 1000 : orderCount);
			// newOrder.setOrderName(personOrder.getOrderName());
			//
			// System.out.println("新订单="+newOrder.hashCode()+"数量="+newOrder.getOrderCount());
			// orderCount -= 1000;
			// }else if(order instanceof CompanyOrder){
			//
			// }
			// 不符合开闭原则

			System.out.println("原来订单" + order.hashCode());

			IOrder newOrder = (IOrder) order.clonePrototype();
			newOrder.setOrderCount(orderCount > 1000 ? 1000 : orderCount);
			System.out.println("newOrder=" + newOrder.hashCode() + "数量="
					+ newOrder.getOrderCount());

			orderCount = orderCount - 1000;

		}
	}

}
