package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil3 {
	
	private static Properties  pro = new Properties();
	static{
		FileInputStream fis=null;
		try {
			 fis= new FileInputStream("./src/util/conn.properties");
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fis!=null) try{ fis.close();}catch(Exception e){}
		}
	}
	
	public static Connection getConnection() throws Exception{
		Class.forName(pro.getProperty("Driver"));
		Connection conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		return conn;
	}
	
	public static void close( ResultSet rs,Statement stm , Connection conn){
		if( rs!=null ) try{ rs.close(); } catch(Exception e){}
		if( stm!=null ) try{ stm.close();}catch(Exception e){}
		if( conn!=null) try{ conn.close(); } catch(Exception e){ }
	}

}