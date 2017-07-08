package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil2 {
	public static Connection getConnection()throws Exception{
		Properties pro=new Properties();//Map的实现类，键值都为字符串。
		FileInputStream file=new FileInputStream("./src/util/conn.properties");//文件输入流。
		pro.load(file);//读取配置文件。
		file.close();//关闭流。
		Class.forName(pro.getProperty("Driver"));//通过指定键获取属性的方法。
		Connection conn=DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		return conn;
	}
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null) try{rs.close();}catch(Exception e){}
		if(stm!=null) try{stm.close();}catch(Exception e){}
		if(conn!=null) try{conn.close();}catch(Exception e){}
	}
}