package com.allianz.order.person;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;

import org.jdom2.Document;

import com.allianz.order.item.OrderItem;

public class OrderDetails {
	
	private OrderPerson thisPerson;
	private OrderItem thisItem;
	private Integer remQuantity;
	private Integer stockQuantity;
	private Integer msgNr;
	private String msg;
	private Boolean stockValidaity;
	private Document document;
	private Document stockXML;
	private Document orderXML;
	private HashMap<String, Integer> stocklist = new HashMap<String, Integer>();
	private String vsnr;
	private Properties prty;
	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Properties getPrty() {
		return prty;
	}
	public void setPrty(Properties p) {
		this.prty = p;
	}
	public String getVsnr() {
		return vsnr;
	}
	public void setVsnr(String vsnr) {
		this.vsnr = vsnr;
	}
	public HashMap<String, Integer> getStocklist() {
		return stocklist;
	}
	public void setStocklist(HashMap<String, Integer> stocklist) {
		this.stocklist = stocklist;
	}
	public Document getStockXML() {
		return stockXML;
	}
	public void setStockXML(Document stockXML) {
		this.stockXML = stockXML;
	}
	public Document getOrderXML() {
		return orderXML;
	}
	public void setOrderXML(Document orderXML) {
		this.orderXML = orderXML;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Boolean getStockValidaity() {
		return stockValidaity;
	}
	public void setStockValidaity(Boolean stockValidaity) {
		this.stockValidaity = stockValidaity;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getMsgNr() {
		return msgNr;
	}
	public void setMsgNr(Integer msgNr) {
		this.msgNr = msgNr;
	}
	public Integer getRemQuantity() {
		return remQuantity;
	}
	public void setRemQuantity(Integer remQuantity) {
		this.remQuantity = remQuantity;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public OrderPerson getThisPerson() {
		return thisPerson;
	}
	public void setThisPerson(OrderPerson thisPerson) {
		this.thisPerson = thisPerson;
	}
	public OrderItem getThisItem() {
		return thisItem;
	}
	public void setThisItem(OrderItem thisItem) {
		this.thisItem = thisItem;
	}
	
	
	
	

}
