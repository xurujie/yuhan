package com.yuhan.util;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

	//
public static String number(int id,String date) {
	StringBuffer sb=new StringBuffer(date);
	date = sb.substring(0,sb.length()-11);
	Pattern p = Pattern.compile("[^0-9]");
	Matcher m = p.matcher(date.toString()+new Integer(id).toString());
	System.out.println(date);
	return m.replaceAll("").trim();
}
}
