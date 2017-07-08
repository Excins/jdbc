package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil1 {
	public static Connection getConnection()throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn=DriverManager.getConnection(url,"library","library-00");
		return conn;
	}
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null) try{rs.close();}catch(Exception e){}
		if(stm!=null) try{stm.close();}catch(Exception e){}
		if(conn!=null) try{conn.close();}catch(Exception e){}
	}
}