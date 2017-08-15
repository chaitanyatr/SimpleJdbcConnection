package com.jdbc.test;
//DAO
//db
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import com.jdbc.test.Names;
import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.ResultSet;

public class DAO {
	
	//db connection
	public static Connection getConnection() throws Exception{
		Connection dbConn = null;
    try{
    //step1:
    Class.forName("com.mysql.jdbc.Driver");
	//step2
    String url = "jdbc:mysql://localhost:3306/test";
	//step3
	dbConn = DriverManager.getConnection(url, "root", "root");
	}
     catch (SQLException sqle) {
	   sqle.printStackTrace();
	   throw sqle;
	}
         catch(Exception e) {
	   e.printStackTrace();
	   throw e;
	}
return dbConn;
}
	public void addNames(Names name1)  {
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO myinfo(first_name, middle_name, last_name) VALUES (?,?,?)");
		pStmt.setString(1, name1.getFirstName());
		pStmt.setString(2, name1.getMiddleName());
		pStmt.setString(3, name1.getLastName());
		
   		rowsInserted = pStmt.executeUpdate();
   		dbConn.close();
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return;
	}
	
	public static void getAllNames() throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;

	     try{

		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM myinfo");
		rs = (ResultSet) pStmt.executeQuery();
		while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	    }
		return;
	}
}
