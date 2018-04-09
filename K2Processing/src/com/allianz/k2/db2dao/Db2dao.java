package com.allianz.k2.db2dao;

import java.util.ArrayList;

import com.allianz.k2.input.OrderDetails;

public interface Db2dao {

		public ArrayList<K2object> selectK2(OrderDetails thisOrderDetails);
}
