package com.allianz.order.helper;

import com.allianz.order.person.OrderDetails;
import com.allianz.order.stock.Stock;
import com.allianz.order.stock.StockImpl;

public class ProcessingHelperImpl implements ProcessingHelper{

public OrderDetails processOrder(OrderDetails thisOrderDetails) {
		
		Stock st = new StockImpl();
		thisOrderDetails = st.isValidStock(thisOrderDetails);
		if (thisOrderDetails.getStockValidaity()) {
			Integer stockCount = thisOrderDetails.getStockQuantity();
			Integer orderCount = thisOrderDetails.getThisItem().getItem_count();
			thisOrderDetails.setRemQuantity(stockCount);
			if (stockCount > orderCount){
				
				thisOrderDetails.setMsgNr(1);
				
			}
			
			else if (stockCount == orderCount){
				
				thisOrderDetails.setMsgNr(1);
				
			}
			
			else if (stockCount < orderCount){

				thisOrderDetails.setMsgNr(2);
			}
			else if (stockCount == 0){

				thisOrderDetails.setMsgNr(3);
			}
			
			
		}
		else{
			thisOrderDetails.setMsgNr(0);
		}
				
		return thisOrderDetails;
	}
	
	
	public OrderDetails createMessage(OrderDetails thisOrderDetails){
		
		String statusMessage = null;
		
		Integer msgNr = thisOrderDetails.getMsgNr();
		String personName = thisOrderDetails.getThisPerson().getName();
		String personMobile = thisOrderDetails.getThisPerson().getMobile();
		String itemName = thisOrderDetails.getThisItem().getItem();
		Integer itemCount = thisOrderDetails.getThisItem().getItem_count();
		Integer remQualtity = thisOrderDetails.getRemQuantity();
		
		if (msgNr == 1){
			Stock st1 = new StockImpl();
			remQualtity = remQualtity - itemCount;
			thisOrderDetails.setRemQuantity(remQualtity);
			st1.putStockCount(thisOrderDetails);
		}
		
		switch (msgNr){
		
		case 0:
			statusMessage = "Dear " + personName + ", We are sorry." + itemName + " is not available at our store.";
			break;
		case 1:
			statusMessage = "Dear " + personName + ",Your order of " + itemCount + " " + itemName + "(s) is successfully processed. We will contact you on your mobile: " + personMobile + " shortly for completing the transaction .";
			break;
		case 2:
			statusMessage = "Dear " + personName + ",Your order of " + itemCount + " " + itemName + "(s) cannot be processed as we have only : " + remQualtity + " " + itemName + "(s) available in the store.";
			break;
		case 3:
			statusMessage = "Dear " + personName + ",Your order of " + itemCount + " " + itemName + "(s) cannot be processed as we ran out of stock on this item. Please come back later.";
			break;
		}
		
		thisOrderDetails.setMsg(statusMessage);
		return thisOrderDetails;
		
	}
	
	public void orderMessage(OrderDetails thisOrderDetails){
		
		System.out.println(thisOrderDetails.getMsg());
		
	}
}
