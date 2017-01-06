package com.tms.visa.base.converter;

import com.tms.visa.base.exception.DateFormatException;

import java.util.Date;

/**
 * @author 王成委
 * 
 * 日期的格式化
 */
public interface SimpleDateFormater {
	public static final String DATE = "yyyy-MM-dd";
	public static final String DATE_HM = "yyyy-MM-dd HH:mm";
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_MS = "yyyy-MM-dd HH:mm:ss.S";
	//public static final String CN_DATE = "yyyy年MM月dd日";
	//public static final String CN_DATE_TIME = "yyyy年MM月dd日 HH:mm:ss.S";
	public String doFormat(Date date)  throws DateFormatException;
	
}
