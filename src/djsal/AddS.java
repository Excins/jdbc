package djsal;

import java.text.SimpleDateFormat;


public class AddS {
	public  static void main(String[] agrs)throws Exception{
		java.util.Date date=new java.util.Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("h:mm a" );//设置时间的显示格式。
		String dates=sdf.format(date);//将Date转换为字符串显示。
		System.out.println(dates);
		java.util.Date date2=sdf.parse(dates);//将字符串类型的日期转换成Date。
		System.out.println(date2);
	}
}
