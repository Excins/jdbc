package account;

import java.io.FileInputStream;
import java.sql.Connection;

import util.JdbcUtil3;

public class BankService {
	private  AccountDao  dao = new AccountDao();
	//开户
	// 存钱
	//取钱
	// 转账
	public void transfer(Integer fromId,String password,Integer toId,double money) throws Exception{
		 Connection conn = null;
		 try{
			  conn = JdbcUtil3.getConnection();
			  conn.setAutoCommit(false);
			  
		// 1. 判断转出账号信息是否正确
        Account fromA = dao.queryAccountByCardId(fromId);
        if( fromA==null )  throw new Exception("卡号不存在,请确认后重新输入!!");
		    if( !fromA.getPassword().equals(password) ) throw new Exception( "密码错误!!!");
		    if( fromA.getBalance()<money ) throw new Exception("余额不足!!!");
		    
		    //2. 判断转入账户是否存在
		    Account  toA = dao.queryAccountByCardId(toId);
		    if( toA==null ) throw new Exception("转出账号不存在,请确认后重新输入!!");
		    
		    //3. 转账
		    fromA.setBalance(  fromA.getBalance() - money );
		    dao.updateAccount(fromA);
		    
		    FileInputStream  is = new FileInputStream("a.txt");
		    
		    toA.setBalance( toA.getBalance() + money );
		    dao.updateAccount(toA);
		    
		    conn.commit();
		 }catch(Exception e){
			 conn.rollback();
			 throw e;
		 }finally{
			 JdbcUtil3.close(null, null, conn);
		 }
	}
	
		// 查询
		// 修改密码
		// 登陆
}
