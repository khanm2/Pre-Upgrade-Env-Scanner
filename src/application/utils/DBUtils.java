/**
 *  � 2014 Engineering Customer Success. Pegasystems Worldwide Pvt.Ltd
 */
package application.utils;

/**
 * @author ramas6
 * 
 * DB related methods
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;


import application.DBMetaData;



public final class DBUtils 
{

	public static DBMetaData getConnection (String dbtype, String jdbcurl, String username, String password, String ruleSchema, String dataSchema)
	{
		DBMetaData dbConnect = new DBMetaData();
		try 
		{
			//establish connection
			Connection  connection = DriverManager.getConnection(jdbcurl,username,password); 
			dbConnect.setConnection(connection);
			dbConnect.setConnSuccess(true);
			
			//set other details
			dbConnect.setDbType(dbtype);
			dbConnect.setJDBCUrl(jdbcurl);
			dbConnect.setRulesName(ruleSchema);
			dbConnect.setDataName(dataSchema);
			dbConnect.setUserName(connection.getMetaData().getUserName());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			dbConnect.setConnection(null);
			dbConnect.setConnSuccess(false);
			dbConnect.setErrorMessage(e.getMessage());
		}
		
		return dbConnect;
	}
	
	
}
