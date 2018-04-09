package com.allianz.k2.db2dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.allianz.k2.input.OrderDetails;
import com.ibm.db2.jcc.DB2Connection;
import com.ibm.db2.jcc.DB2DataSource;
import com.ibm.db2.jcc.DB2SystemMonitor;

public class GetConnection {
	
	private static String dbSchema;
	private static String dbSchemaProcedures;
	
	
	public Connection getConnection(OrderDetails thisOrderDetails) throws SQLException {
		
		DB2DataSource ds = new DB2DataSource();
		
		Properties p = thisOrderDetails.getPrty();

		// get all configuration itmes from config file
		String databaseName = p.getProperty("DatabaseName");
		String serverName = p.getProperty("ServerName");
		int portNumber = Integer.parseInt(p.getProperty("PortNumber"));
		String user = p.getProperty("User");
		String password = p.getProperty("Password");
		String dbCollection = p.getProperty("DbCollection");
		String db2Monitor = p.getProperty("DB2Monitor");
		//String db2TraceLevel = p.getProperty("DB2TraceLevel");
		
		dbSchema = p.getProperty("DbSchema");
		dbSchemaProcedures = p.getProperty("DbSchemaProcedures");
		
		System.out.println("DatabaseName = " + databaseName);
		System.out.println("ServerName = " + serverName);
		System.out.println("PortNumber = " + portNumber);
		System.out.println("User = " + user);
		System.out.println("password = " + password);
		System.out.println("DbSchema = " + dbSchema);
		System.out.println("DbSchemaProcedures = " + dbSchemaProcedures);
		System.out.println("DbCollection = '" + dbCollection + "'");
		
		// Set the parameters for the JDBC-Connection
		ds.setDriverType(4);
		ds.setDatabaseName(databaseName);
		ds.setServerName(serverName);
		ds.setPortNumber(portNumber);
		ds.setUser(user);
		ds.setPassword(password);
		ds.setCurrentPackagePath("NULLID," + dbCollection);

		ds.setRetrieveMessagesFromServerOnGetMessage(true);
		
		Connection con = null;
		con = ds.getConnection();
		System.out.println("In connection success");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("In connection failure");
//			StackTraceElement stack[] = e.getStackTrace();
//			if (null != stack) {
//			System.out.println("*** Cause Stack Trace: ");
//			for (int j = 0; j < stack.length; j++) {
//			System.out.println("***  " + stack[j].toString());
//			}
//			}
//			e.printStackTrace();
//			
//			int dbSqlCode = ((SQLException) e).getErrorCode();
//			// message block for database messages
//			/*
//			* Print out SQL Execption if available
//			*/
//			System.out.println("*** *Root* Cause: SQLCODE= " + dbSqlCode + ",SQLMessage= " + e.getMessage());
//			System.out.println("In connection failure2");
//		}
//		
//		try {
			con.setAutoCommit(false);
			if (null != db2Monitor && db2Monitor.toUpperCase().startsWith("Y")) {
				DB2SystemMonitor systemMonitor = ((DB2Connection) con).getDB2SystemMonitor();
				systemMonitor.enable(true);
				systemMonitor.start(DB2SystemMonitor.RESET_TIMES);
			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return con;
	}
	
	public static void closeConnection(Connection con) {
		/*
		 * check if monitoring active
		 */
		try {
			DB2SystemMonitor systemMonitor = ((DB2Connection) con).getDB2SystemMonitor();
			if (null != systemMonitor) {
				systemMonitor.stop();
				System.out.println("### Server elapsed time =" + systemMonitor.getServerTimeMicros() + " us, Application " + systemMonitor.getApplicationTimeMillis() + " ms.");
				try {
					System.out.println("### Network I/O elapsed time (microseconds)=" + systemMonitor.getNetworkIOTimeMicros());
					System.out.println("### Core driver elapsed time (microseconds)=" + systemMonitor.getCoreDriverTimeMicros());
				}
				catch(SQLException ex){
					System.out.println("### Monitoring fails, not running in IBM JVM?");
				}
				System.out.println("### Application elapsed time (milliseconds)=" + systemMonitor.getApplicationTimeMillis());
			}
			con.close();
			System.out.println("Connection closed.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * @return the dbSchema
	 */
	public static String getDbSchema() {
		return dbSchema;
	}

	/**
	 * @return the dbSchema
	 */
	public static String getDbSchemaProcedures() {
		return dbSchemaProcedures;
	}
	
	

}
