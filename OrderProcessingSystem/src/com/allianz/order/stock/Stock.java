package com.allianz.order.stock;

import com.allianz.order.person.OrderDetails;
import com.allianz.order.xml.EmployeeJDomXML;


public interface Stock {
	
	public OrderDetails isValidStock(OrderDetails thisOrderDetails);
	public OrderDetails getStockCount(OrderDetails thisOrderDetails);
	public void putStockCount(OrderDetails thisOrderDetails);

}
