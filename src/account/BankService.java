package account;

import java.io.FileInputStream;
import java.sql.Connection;

import util.JdbcUtil3;

public class BankService {
	private  AccountDao  dao = new AccountDao();
	//����
	// ��Ǯ
	//ȡǮ
	// ת��
	public void transfer(Integer fromId,String password,Integer toId,double money) throws Exception{
		 Connection conn = null;
		 try{
			  conn = JdbcUtil3.getConnection();
			  conn.setAutoCommit(false);
			  
		// 1. �ж�ת���˺���Ϣ�Ƿ���ȷ
        Account fromA = dao.queryAccountByCardId(fromId);
        if( fromA==null )  throw new Exception("���Ų�����,��ȷ�Ϻ���������!!");
		    if( !fromA.getPassword().equals(password) ) throw new Exception( "�������!!!");
		    if( fromA.getBalance()<money ) throw new Exception("����!!!");
		    
		    //2. �ж�ת���˻��Ƿ����
		    Account  toA = dao.queryAccountByCardId(toId);
		    if( toA==null ) throw new Exception("ת���˺Ų�����,��ȷ�Ϻ���������!!");
		    
		    //3. ת��
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
	
		// ��ѯ
		// �޸�����
		// ��½
}
