package cn.hxl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 返回当前日期 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String showTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(showTime());
	}
	
}
