package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil2 {
	public static Connection getConnection()throws Exception{
		Properties pro=new Properties();//Map��ʵ���࣬��ֵ��Ϊ�ַ�����
		FileInputStream file=new FileInputStream("./src/util/conn.properties");//�ļ���������
		pro.load(file);//��ȡ�����ļ���
		file.close();//�ر�����
		Class.forName(pro.getProperty("Driver"));//ͨ��ָ������ȡ���Եķ�����
		Connection conn=DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
		return conn;
	}
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null) try{rs.close();}catch(Exception e){}
		if(stm!=null) try{stm.close();}catch(Exception e){}
		if(conn!=null) try{conn.close();}catch(Exception e){}
	}
}