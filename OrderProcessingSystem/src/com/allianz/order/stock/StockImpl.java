package com.allianz.order.stock;

import java.util.HashMap;

import com.allianz.order.person.OrderDetails;
import com.allianz.order.xml.EmployeeJDomXML;

public class StockImpl implements Stock {
	
		public int stock_count;
		public static HashMap<String, Integer> stocklist = new HashMap<String, Integer>();
		
		public StockImpl(){
			
		}
		public StockImpl(OrderDetails thisOrderDetails, EmployeeJDomXML jDomXML){
				
			jDomXML.readStock(thisOrderDetails);
			
			
		}
		
	public OrderDetails isValidStock(OrderDetails thisOrderDetails) {
		// TODO Auto-generated method stub
		thisOrderDetails.setStockValidaity(thisOrderDetails.getStocklist().containsKey(thisOrderDetails.getThisItem().getItem()));
		thisOrderDetails.setStockQuantity(thisOrderDetails.getStocklist().get(thisOrderDetails.getThisItem().getItem()));
		return thisOrderDetails;
	}

	public OrderDetails getStockCount(OrderDetails thisOrderDetails) {
		// TODO Auto-generated method stub
		
		thisOrderDetails.setStockQuantity(thisOrderDetails.getStocklist().get(thisOrderDetails.getThisItem().getItem()));
		return thisOrderDetails;
	}

	public void putStockCount(OrderDetails thisOrderDetails) {
		// TODO Auto-generated method stub
		thisOrderDetails.getStocklist().put(thisOrderDetails.getThisItem().getItem(),thisOrderDetails.getRemQuantity());
		
	}
	
}
