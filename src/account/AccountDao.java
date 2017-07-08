package account;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JdbcUtil3;

public class AccountDao {
	//注册账户
	public  Integer insertAccount(Account a)throws Exception{
		Connection conn=null;
		Statement stm=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtil3.getConnection();
			stm=conn.createStatement();
			String sqlQuery="select account_seq.nextval from dual";
			rs=stm.executeQuery(sqlQuery);
			Integer id=null;
			if(rs.next()){ id=rs.getInt(1);}
			
			String sql="insert into account values(?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, a.getName());
			pstm.setString(3, a.getPassword());
			pstm.setDouble(4, a.getBalance());
			pstm.executeUpdate();
			return id;
		}finally{
			JdbcUtil3.close(rs, stm, null);
			JdbcUtil3.close(null, pstm, conn);
		}
	}
	//查询账户信息。
	public Account queryAccountByCardId(Integer cardId) throws Exception{
		 Connection conn = null;
		 PreparedStatement pstm=null;
		 ResultSet rs =null;
		 try{
			 conn = JdbcUtil3.getConnection();
			 String sql = "select * from account where cardId=?";
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, cardId);
			 rs = pstm.executeQuery();
			 Account  a  = null;
			 if(rs.next()){
				 Integer id = rs.getInt(1);
				 String name = rs.getString(2);
				 String password = rs.getString(3);
				 double balance = rs.getDouble(4);
				 
				 a = new Account(id,name,password,balance);
			 }
			 return a;
		 }finally{
			  JdbcUtil3.close(rs,pstm,conn);
		 }
	}
	//修改账户信息。
	public void updateAccount(Account a) throws Exception{
		Connection conn =null;
		PreparedStatement pstm = null;
		try{
			conn = JdbcUtil3.getConnection();
			
			String sql = "update account set name=?,password=?,balance=? where cardId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, a.getName());
			pstm.setString(2, a.getPassword());
			pstm.setDouble(3, a.getBalance());
			pstm.setInt(4, a.getId());
			pstm.executeUpdate();
			
		}finally{
			JdbcUtil3.close(null, pstm, conn);
		}
		//删除账户
		
	}
} 
