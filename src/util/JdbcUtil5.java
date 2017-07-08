package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil5 {
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	public static Connection getConnection() throws Exception{
		Connection conn=tl.get();
		if(conn==null){
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn=ds.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	public static void close( ResultSet rs,Statement stm , Connection conn){
		if( rs!=null ) try{ rs.close(); } catch(Exception e){}
		if( stm!=null ) try{ stm.close();}catch(Exception e){}
		if( conn!=null) try{ conn.close(); tl.remove();} catch(Exception e){ }
	}

}