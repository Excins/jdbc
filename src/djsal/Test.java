package djsal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test{
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8";
		Connection conn=DriverManager.getConnection(url,"root","root");
		String sql="select * from course_user";
		PreparedStatement pstm=conn.prepareStatement(sql);
//		pstm.setString(1, "you");
		ResultSet rs=pstm.executeQuery();
		if(rs.next()){
			System.out.println(rs.getInt(1)+"-------------"+rs.getInt(2));
		}
		pstm.close();
		conn.close();
	}
}
class Mystock extends Thread{
	char[] c={'a','b',' '};
	int index=2;
	private Object lock=new Object();
	public void push(char ch){
		synchronized(lock){
			c[index]=ch;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			index++;
		}
	}
	public void pop(){
		synchronized(lock){
			index--;
			c[index]=' ';
		}
	}
	public void print(){
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"  ");
		}
		System.out.println();
	}
}






