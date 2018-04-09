package com.allianz.k2.main;

import java.util.ArrayList;

import com.allainz.k2.output.K2output;
import com.allianz.k2.db2dao.Db2dao;
import com.allianz.k2.db2dao.Db2daoImpl;
import com.allianz.k2.db2dao.K2object;
import com.allianz.k2.input.OrderDetails;

public class K2Main {
	public static  Integer arg_count,orderCount=0,resp; 
	public static String[] order_detail = new String[4];

	/**
	 * @param args
//	 
	 * @throws FileNotFoundException1 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			
		
		OrderDetails thisOrderDetails = new OrderDetails();
		K2output ko = new K2output();
		ko.outcreator();
//		arg_count = args.length;
//		arg_count--;
//		
//		while(orderCount <= arg_count)
//		{
			//Convert the input to details
			thisOrderDetails.setVsnr("0000000009");
			
			//Get the hinweise
			Db2dao getRec = new Db2daoImpl();
			ArrayList<K2object> k2Objects = getRec.selectK2(thisOrderDetails);
			System.out.println("received Objects");
			for(int i=0;i<k2Objects.size();i++){
				System.out.println("Writing File");
				ko.outWriter(k2Objects.get(i));
			}
			ko.closeWriter();
//			orderCount++;
////		}
//		
		
	}

	
}
