package com.allianz.order.conversion;

public class OrderConversionImpl implements OrderConversion{

	public static String[] order_detail = new String[4];
	
	public String[] convertOrder(String order){
		int a,b,c,d=0;
		a = 0;
		while(d<4)
		{
			a = order.indexOf("<");
			b = order.indexOf(">");
			c = b - a;
			order_detail[d] = order.substring(a+1, c);
			d= d+1;
			order = order.substring(b+1);
		}
		
		return order_detail;
		
		
	}
}
