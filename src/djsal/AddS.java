package djsal;

import java.text.SimpleDateFormat;


public class AddS {
	public  static void main(String[] agrs)throws Exception{
		java.util.Date date=new java.util.Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("h:mm a" );//����ʱ�����ʾ��ʽ��
		String dates=sdf.format(date);//��Dateת��Ϊ�ַ�����ʾ��
		System.out.println(dates);
		java.util.Date date2=sdf.parse(dates);//���ַ������͵�����ת����Date��
		System.out.println(date2);
	}
}
