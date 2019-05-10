package com.ant.scq.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
	private static final SimpleDateFormat TEMPDATE1 = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private static final SimpleDateFormat TEMPDATE2 = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat TEMPDATE3 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	public static java.util.Date getAddDateFromNow(int number, int type) {
		Calendar calendar = Calendar.getInstance();
		if (type == 0)
			calendar.add(2, number);
		else if (type == 1) {
			calendar.add(1, number);
		}
		java.util.Date updateTime = calendar.getTime();
		return updateTime;
	}

	public static java.util.Date getAddDateFromDate(java.util.Date date,
			int number, int type) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (type == 0)
			calendar.add(2, number);
		else if (type == 1) {
			calendar.add(1, number);
		}
		java.util.Date updateTime = calendar.getTime();
		return updateTime;
	}

	public static java.util.Date getNowTime() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date nowTime = calendar.getTime();
		return nowTime;
	}

	public static java.util.Date changeToTimeZoneDate(java.util.Date date,
			String timeZoneNumber) {
		TimeZone tz = getTimeZone(timeZoneNumber);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setTimeZone(tz);

		return calendar.getTime();
	}

	public static TimeZone getTimeZone(String timeZoneNumber) {
		String gmt = "";
		if (timeZoneNumber != null) {
			int length = timeZoneNumber.length();
			String d = "";
			String f = "";
			if (length == 1) {
				gmt = "GMT";
			} else if (timeZoneNumber.startsWith("-")) {
				d = timeZoneNumber.substring(0, 1);
				f = timeZoneNumber.substring(1, length);
				gmt = "GMT+" + Integer.parseInt(f) / 60;
			} else {
				gmt = "GMT-" + Integer.parseInt(timeZoneNumber) / 60;
			}
		} else {
			return TimeZone.getTimeZone("GMT-7");
		}
		return TimeZone.getTimeZone(gmt);
	}

	public static String date2String(java.util.Date date, String dateStyle) {
		SimpleDateFormat formater = new SimpleDateFormat(dateStyle);
		String str = "";
		try {
			str = formater.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static java.util.Date string2Date(String sDate, String dateStyle) {
		SimpleDateFormat formater = new SimpleDateFormat(dateStyle);
		java.util.Date date = null;
		try {
			date = formater.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date string2Date(String sDate) {
		Date date = null;
		try {
			date = TEMPDATE3.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static java.sql.Date string2SqlDate(String sDate, String dateStyle) {
		SimpleDateFormat formater = new SimpleDateFormat(dateStyle);
		java.sql.Date date = null;
		try {
			date = new java.sql.Date(formater.parse(sDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static java.sql.Date string2SqlDate(String sDate) {
		java.sql.Date date = null;
		try {
			date = new java.sql.Date(TEMPDATE3.parse(sDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	public static void main(String[] args) {
		BigDecimal totalPrice = new BigDecimal("0");

		BigDecimal totalPrice1 = new BigDecimal("100");

		BigDecimal totalPrice2 = new BigDecimal("20");

		System.out.println(totalPrice.add(totalPrice1).add(totalPrice2)
				.doubleValue());
	}

	private static String date2String2(String time, String dateStyle) {
		if (StringUtils.isBlank(time)) {
			return "";
		}

		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = null;
		try {
			date = formater.parse(time);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if (StringUtils.isBlank(dateStyle)) {
			dateStyle = "yyyy-MM-dd hh:mm:ss";
		}
		SimpleDateFormat f2 = new SimpleDateFormat(dateStyle);
		String str = "";
		try {
			str = f2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	public static String getDateForLocale(java.util.Date date, Locale locale) {
		DateFormat df = DateFormat.getDateInstance(2, locale);
		return df.format(date);
	}

	public static String getDateForLocale(String sDate, String dateStyle,
			Locale locale) {
		java.util.Date date = string2Date(sDate, dateStyle);
		DateFormat df = DateFormat.getDateInstance(2, locale);
		return df.format(date);
	}

	public static String getCurrentDate() {
		String datetime = TEMPDATE3.format(new java.util.Date());
		return datetime;
	}

	public static String getChangeDate(java.util.Date date) {
		if (date != null) {
			String datetime = TEMPDATE2.format(date);
			return datetime;
		}
		return "";
	}

	public static String getFormatChangeDate(String dateString) {
		if (dateString != null) {
			String datetime = "";
			try {
				datetime = TEMPDATE2.format(TEMPDATE2.parse(dateString));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return datetime;
		}
		return "";
	}

	public static java.util.Date getGmtDate() {
		Calendar calendar = Calendar.getInstance();
		int offset = calendar.get(15) / 3600000 + calendar.get(16) / 3600000;
		calendar.add(10, -offset);
		java.util.Date date = calendar.getTime();
		return date;
	}

	public static java.util.Date long2Date(long time) {
		java.util.Date d = new java.util.Date(time);
		return d;
	}

	public static int getWeekDay() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int day = c.get(7);
		switch (day) {
		case 1:
			return 7;
		}
		return day - 1;
	}

	public static String getOrderEndTime(String workTime, int hour_before) {
		int weekDay = getWeekDay();
		int hour = Integer.valueOf(
				workTime.substring((weekDay - 1) * 8 + 4, weekDay * 8 - 2))
				.intValue();

		return hour - hour_before + ":"
				+ workTime.substring(weekDay * 8 - 2, weekDay * 8);
	}

	public static java.util.Date getEndDateTime(String workTime, int hour_before) {
		int weekDay = getWeekDay();
		int hour = Integer.valueOf(
				workTime.substring((weekDay - 1) * 8, weekDay * 8 + 2))
				.intValue();

		String endDate = TEMPDATE2.format(new java.util.Date()) + " "
				+ (hour - hour_before) + ":"
				+ workTime.substring(weekDay * 8 - 2, weekDay * 8) + ":00";
		return string2Date(endDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean isSameDay(java.util.Date date1, java.util.Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return false;
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isSameDay(cal1, cal2);
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if ((cal1 == null) || (cal2 == null)) {
			return false;
		}
		return (cal1.get(0) == cal2.get(0)) && (cal1.get(1) == cal2.get(1))
				&& (cal1.get(6) == cal2.get(6));
	}

	public static String getRecommendDate(String workTime, int hour_before) {
		int weekDay = getWeekDay();
		int hour = Integer.valueOf(
				workTime.substring((weekDay - 1) * 8 + 4, weekDay * 8 - 2))
				.intValue();

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int nowHour = c.get(11);
		if (hour - nowHour < hour_before)
			c.add(6, 1);
		return date2String(c.getTime(), "yyyy-MM-dd");
	}

	public static java.util.Date getFirstDayOfMonth(java.util.Date date) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);
		cDay.set(5, 1);
		System.out.println(cDay.getTime());
		return cDay.getTime();
	}

	private static String getLastDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		java.util.Date theDate = calendar.getTime();
		String s = df.format(theDate);
		StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
		return str.toString();
	}

	public static boolean compateDate(java.util.Date intputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = false;
		try {
			java.util.Date nowDate = new java.util.Date();
			if (intputDate != null)
				if (sdf.parse(sdf.format(nowDate)).getTime() == intputDate
						.getTime()) {
					flag = true;
				} else if (sdf.parse(sdf.format(nowDate)).getTime() > intputDate
						.getTime())
					flag = false;
				else
					flag = false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}
}