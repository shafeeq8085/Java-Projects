package com.allianz.order.item;

public class OrderItem {
	
	public String item;
	public int item_count;
	
	public OrderItem(String item, int item_count){
		
		this.item = item;
		this.item_count = item_count;
		
	}
	
	public OrderItem(){
		
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	

}
