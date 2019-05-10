package com.ant.scq.util;

public class StringUtil {

	public static boolean isNullOrEmpty(String text){
		return text == null || text.trim().length() == 0;
	}
	
	public static String isEmptyValue(Object obj){
		if(obj != null){
			return obj.toString();
		}
		return "";
	}
}
