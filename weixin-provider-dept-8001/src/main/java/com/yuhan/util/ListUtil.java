package com.yuhan.util;

import java.util.ArrayList;
import java.util.List;
import com.yuhan.entities.Banner;
import com.yuhan.entities.Belongs;


public class ListUtil {
	public static String bannerlistToString( List<Banner> list){
		StringBuffer sb =new StringBuffer();
		sb.append("[");
		list.forEach(e->
		sb.append(e.toString()+","));
		StringBuffer sb0=sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb0.toString();
	}
	
	public static String belongslistToString( List<Belongs> list){
		StringBuffer sb =new StringBuffer();
		sb.append("[");
		list.forEach(e->
		sb.append(e.toString()+","));
		StringBuffer sb0=sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb0.toString();
	}
public static void main(String[] args) {
	/*Banner a =new Banner(1,"2","3");
	Banner b =new Banner(2,"3","4");
	Banner c =new Banner(3,"4","5");
System.out.println(a);
System.out.println(b);
System.out.println(c);
StringBuffer sb =new StringBuffer();
sb.append(a.toString());
sb=sb.deleteCharAt(sb.length()-1);
System.out.println(sb);
*/
	Belongs b = new Belongs(1,"2","3","4");
	System.out.println(b);
	
}
}
