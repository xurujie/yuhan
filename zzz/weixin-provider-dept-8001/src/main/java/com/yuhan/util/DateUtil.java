package com.yuhan.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	/**
	 * 用某种时间格式，格式化字符串
	 * @param date   日期
	 * @return
	 */
	public static String formate(Date date ,String formaStr){
	
		SimpleDateFormat sdf = new SimpleDateFormat(formaStr);
		String result = sdf.format(date);
		return result;
	}
	public static String formate0(Date date ,String formaStr){

		SimpleDateFormat sdf = new SimpleDateFormat(formaStr);
		String result = sdf.format(date);
		result =result.replaceAll("\t","");
		return result;
	}
	public static Timestamp formateAdd30minute(Date date){

		long time = date.getTime();
		return new Timestamp(time+1800000);

	}

	public static Timestamp formateAddMonth(Date date,int i){
		long time = date.getTime();
		return new Timestamp(time+1000*60*60*24*30*i);
	}
	/**
	 * 按给定的格式把指定的字符串转化为时间
	 * @param formaStr 
	 * @param value 
	 * @return
	 */
	
	public static Date parseDate(String formaStr,String value){
		SimpleDateFormat sdf = new SimpleDateFormat(formaStr);
		Date date = null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}


	public static boolean isSameDate(String date1, String date2)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setFirstDayOfWeek(Calendar.MONDAY);//西方周日为一周的第一天，咱得将周一设为一周第一天
		cal2.setFirstDayOfWeek(Calendar.MONDAY);
		cal1.setTime(d1);
		cal2.setTime(d2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (subYear == 0)// subYear==0,说明是同一年
		{
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) //subYear==1,说明cal比cal2大一年;java的一月用"0"标识，那么12月用"11"
		{
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11)//subYear==-1,说明cal比cal2小一年
		{
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	


//判断今天周几
public static  int DateDay(){
	Date today = new Date();
	Calendar c=Calendar.getInstance();
	c.setTime(today);
	int weekday=c.get(Calendar.DAY_OF_WEEK);
	if(weekday==1){
		weekday=7;
	}else {
		weekday--;
	}

return weekday;
}



//判断两天相差几天
public  static  long numberOfDaysDifference(Date d1,Date d2) throws ParseException {

		String s1=DateUtil.formate(d1,"yyyy-MM-dd");
	String s2=DateUtil.formate(d2,"yyyy-MM-dd");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");

	Date d01=sdf.parse(s1);

	Date d02=sdf.parse(s2);

	return (d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);

}

	public static void main(String[] args) throws ParseException {
/*	Date a = new Date();
	System.out.println(DateUtil.formate(a, "yyyy-MM-dd	HH:mm:ss"));*/
/*
		boolean a = isSameDate("2019-08-31", "2019-08-26");
		if (a) {
			System.out.println("是同一周！");
		} else {
			System.out.println("不是同一周！");
		}*/

/*System.out.println(DateUtil.DateDay());*/


			String date1="2019-08-29";

			String date2="2019-08-31";

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");

			Date d1=sdf.parse(date1);

			Date d2=sdf.parse(date2);

			long daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);

			System.out.println("1987-01-01 与 2010-01-01 相隔 "+daysBetween+" 天");
		System.out.println(DateUtil.formate(new Date(), "yyyy-MM-dd"));

	}

}
