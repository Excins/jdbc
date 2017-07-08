package djsal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Person;

import util.JdbcUtil4;

public class Add {
	public void updatePerson(Person p) throws Exception{
		//±à¼­
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=JdbcUtil4.getConnection();
			String sql="update person set id=?,name=?,mobile=?,email=?,city=?,birthday=? where name=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, p.getAge());
			pstm.setString(2, p.getName());
			pstm.setString(3, p.getMobile());
			pstm.setString(4, p.getEmail());
			pstm.setString(5, p.getCity());
			java.util.Date birth=p.getBirthday();
			long time=birth.getTime();
			java.sql.Date birthday=new java.sql.Date(time);
			pstm.setDate(6, birthday);
			pstm.setString(7, "afa");
			pstm.executeUpdate();
		} finally{
			JdbcUtil4.close(null, pstm, null);
		}
		System.out.println("end");
	}
}
