package com.allianz.k2.db2dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.allianz.k2.confiq.readProperty;
import com.allianz.k2.input.OrderDetails;

public class Db2daoImpl implements Db2dao {
	
//	private static Logger loggerSlf4J = LoggerFactory.getLogger(Db2daoImpl.class);
	@Override
	public ArrayList<K2object> selectK2(OrderDetails thisOrderDetails) {
		// TODO Auto-generated method stub
		Connection con = null;
		String documentTableName = null;
		String vsnr, hinweise;
		ArrayList<K2object> k2Objects = new ArrayList<K2object>();
		readProperty prty = new readProperty();
		Properties p = prty.readProperties();
		thisOrderDetails.setPrty(p);
		
		System.out.println("Received Properties");
		GetConnection gc = new GetConnection();
		
		try{
			
			con = gc.getConnection(thisOrderDetails);
		
		} catch(SQLException ex){
			Exception cause = (Exception) ex.getCause();

			if (null != cause) {
				// detail message ?
				String detailMessage = cause.getMessage();
				String causeClass = cause.getClass().getName();
				System.out.println("*** Cause: " + causeClass);
				if (null != detailMessage) {
					System.out.println("*** Message of " + causeClass + ": " + cause.getMessage());
				}
				StackTraceElement stack[] = cause.getStackTrace();
				if (null != stack) {
					System.out.println("*** Cause Stack Trace: ");
					for (int i = 0; i < stack.length; i++) {
						System.out.println("***  " + stack[i].toString());
					}
				}
			}
	
		}
		System.out.println("Received Connection");
		documentTableName = "TEST.TBCO_K2_VERL_HINW";
		thisOrderDetails.setCon(con);
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select VSNR, HINWEIS");
		sqlBuffer.append(" from " + documentTableName + "   ");
		sqlBuffer.append(" where  VSNR     = '" + thisOrderDetails.getVsnr() + "'    ");
//		sqlBuffer.append(" fetch first row only           ");
		sqlBuffer.append(" with ur                        ");
		String sql = sqlBuffer.toString();
		
		System.out.println("SQL : "+ sql);

		try {
			System.out.println("preparing statement");
			PreparedStatement pStmt = con.prepareStatement(sql);
			System.out.println("prepared statement");
			ResultSet rs = pStmt.executeQuery();
			System.out.println("executed statement");
			while (rs.next()) {

				// get the docId from the resultset (column 1) and create the
				// APKVDocument object
				K2object thisK2object = new K2object();
				System.out.println("Getting the records");
				vsnr = rs.getString(1);
				hinweise = rs.getString(2);
				thisK2object.setVsnr(vsnr);
				thisK2object.sethinweise(hinweise);
				
				k2Objects.add(thisK2object);
				System.out.println("VSNR"+ vsnr);
				System.out.println("hinweise"+ hinweise);
			} 	
			System.out.println("Done with the records");
			rs.close();
			pStmt.close();
			System.out.println("Closed Connections");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Object: "+k2Objects.get(1));
		
		return k2Objects;
	}

}
