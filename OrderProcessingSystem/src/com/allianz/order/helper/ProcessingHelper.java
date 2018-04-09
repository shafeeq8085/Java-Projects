package com.allianz.order.helper;

import com.allianz.order.person.OrderDetails;

public interface ProcessingHelper {
	
	public OrderDetails processOrder(OrderDetails thisOrderDetails);	
	
	public OrderDetails createMessage(OrderDetails thisOrderDetails);
	
	public void orderMessage(OrderDetails thisOrderDetails);

}
