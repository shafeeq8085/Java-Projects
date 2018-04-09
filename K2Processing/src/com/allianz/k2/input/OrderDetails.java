package com.allianz.k2.input;

import java.sql.Connection;
import java.util.Properties;

public class OrderDetails {
	
	private String vsnr;
	private Properties prty;
	private Connection con;
	private String psw;
	private String outPath;
	
	public String getOutPath() {
		return outPath;
	}
	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
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

}
